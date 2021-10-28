package com.viden.bandtec.videnws.arquivos.exportacao;
import com.viden.bandtec.videnws.dominio.Empresa;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TesteEmpresaTxt {

//GRAVA REGISTRO
    public static void gravaRegistro(String registro, String nomeArq){
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq,true));
        } catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: "+ erro.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: "+ erro.getMessage());
        }

    }
    // ---------------------------- ------------------------------ ------------------------- ---------------------------

    //GRAVA ARQUIVO
    public static void gravarArquivoTxt(List<Empresa> lista, String nomeArq){
        int contaRegDados = 0;

       //Monta o registro de header
        String header = "00EMPRESA";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
       header += "01";

        //Grava o header
        gravaRegistro(header, nomeArq);

        //Monta e grava o corpo do arquivo
      for (Empresa empresa : lista) {

            //Registros de Corpo
            String corpo = "02";

            //ID da Empresa
            corpo += String.format("%08d",empresa.getIdEmpresa());
            //Nome da Empresa
            corpo += String.format("%-25.25s",empresa.getNome());
            //CNPJ da Empresa
            corpo += String.format("%-18.18s", empresa.getCnpj());
           //Endereço da Empresa
           corpo += String.format("%-40.40s",empresa.getEndereco());
            //Email da Empresa
           corpo += String.format("%-50.50s",empresa.getEmail());

            //Total de Registros
            contaRegDados ++;
            gravaRegistro(corpo, nomeArq);
        }

        //Monta e grava o registro de Trailer
       String trailer = "01";
       trailer += String.format("%020d", contaRegDados);
       gravaRegistro(trailer, nomeArq);
    }

//--------------------------------- ---------------------------- ---------------------------- --------------------------

    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro;
        String tipoRegistro;
        Integer IdEmpresa = 0;
        String Nome;
        String Cnpj;
        String Endereco;
        String Email;
        int contaRegDados = 0;
        int qtdRegistrosGravados = 0;
        List<Empresa> listaLida = new ArrayList<>();

        //Abre o Arquivo
        try{
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo" + erro.getMessage());
        }

        //Lê o arquivo
        try{
            // Lê o primeiro registro do arquivo
            registro = entrada.readLine();
            while (registro != null){//Enquanto não chegou no fim do arquivo
                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")){
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " +registro.substring(2,10));
                    System.out.println("Data/hora gravação: "+registro.substring(10,28));
                    System.out.println("Versão do documento: "+registro.substring(28,30));
                }
               else if(tipoRegistro.equals("01")){
                    System.out.println("É um registro de trailer");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2,22));
                    if (qtdRegistrosGravados == listaLida.size()){
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }else {
                       System.out.println("Quantidade de registros gravados não confere com quandtidade lida");
                    }
                }
                else if(tipoRegistro.equals("02")){
                    System.out.println("É um registro de corpo");
                    IdEmpresa = Integer.parseInt(registro.substring(2,10));
                    Nome = registro.substring(10,35).trim();
                    Cnpj = registro.substring(35,53).trim();
                    Endereco = registro.substring(53,93).trim();
                    Email = registro.substring(93,143).trim();

                   Empresa empresa = new Empresa(IdEmpresa, Nome,Cnpj,Endereco,Email,null);
                    listaLida.add(empresa);
                    contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }
                // Lê o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro){
       System.out.println("Erro ao ler o arquivo" + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo:");
        for (Empresa empresa : listaLida){
            System.out.println(empresa);
     }
    }

//////----------------------------- --------------------------------- --------------------------- --------------------------

    public  static void main(String[] args) {
        Empresa empresa1 = new Empresa(1,"Accenture","11.222.1111/0001-01", "Rua: Alexandre Dumas, 123",
                "accenture@accenture.com","12345678");
        Empresa empresa2 = new Empresa(2,"Vale Mobi","12.233.1551/0006-02", "Av: Paulista, 34",
                "valemobi@valemobi.com","12345678");
        Empresa empresa3 = new Empresa(3,"Safra","41.242.9181/0051-03", "Av: Paulista, 93",
                "safra@safra.com","12345678");
        Empresa empresa4 = new Empresa(4,"C6BANK","81.662.7889/0661-04", "Av: Consolação, 1003",
                "c6bank@c6bank.com","12345678");
        List<Empresa> lista = new ArrayList<>();
                      lista.add(empresa1);
                      lista.add(empresa2);
                      lista.add(empresa3);
                      lista.add(empresa4);

     gravarArquivoTxt(lista,"Empresa.txt");
     leArquivoTxt("Empresa.txt");
    }
}

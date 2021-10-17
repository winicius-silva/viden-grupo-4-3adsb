package com.viden.bandtec.videnws;

import com.viden.bandtec.videnws.dominio.Empresa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteEmpresaCsv {

       public static void gravaArquivoCsv(ListaObj<Empresa> empresa, String nomeArq){
                    FileWriter arq = null;
                    Formatter saida = null;
                    Boolean deuRuim = false;
                    nomeArq += ".csv";

                   // Bloco try-catch para abrir o arquivo
                    try{
                        arq = new FileWriter(nomeArq, false);
                        saida = new Formatter(arq);
                    }
                    catch (IOException erro){
                        System.out.println("Erro ao abrir o arquivo");
                        System.exit(1);
                    }
                  // Bloco try-catch para percorrer a lista e gravar no arquivo
                    try {
                        for (int i = 0; i < empresa.getTamanho(); i++) {
                            Empresa empresa1 = empresa.getElemento(i);
                            saida.format("%d;%s;%s;%s;%s;%s\n",empresa1.getIdEmpresa(),empresa1.getNome(),
                                    empresa1.getCnpj(),empresa1.getEndereco(), empresa1.getEmail(), empresa1.getSenha());
                        }
                   }
                   catch (FormatterClosedException erro){
                        System.out.println("Erro ao gravar no arquivo");
                        deuRuim = true;

                   }
                    finally {
                        saida.close();
                        try {
                            arq.close();
                        }
                        catch (IOException erro){
                            System.out.println("Erro ao fechar o arquivo");
                            deuRuim = true;
                        }
                        if (deuRuim){
                            System.exit(1);
                        }
                    }
                }

                public static void leExibeArquivoCsv(String nomeArq) {
                    FileReader arq = null;
                    Scanner entrada = null;
                    Boolean deuRuim = false;
                    nomeArq += ".csv";

                   //Bloco try-catch para abrir o arquivo
                    try {
                        arq = new FileReader(nomeArq);
                        entrada = new Scanner(arq).useDelimiter(";|\\n");
                   }
                    catch(FileNotFoundException erro){
                        System.out.println("Arquivo não encontrado");
                        System.exit(1);
                    }

                    //Bloco try-catch para ler o arquivo
                    try {
                      System.out.printf("%8s %-25s %20s %-40s %-50s %-15s\n", "IDEMPRESA", "NOME", "CNPJ", "ENDEREÇO", "EMAIL",
                                "SENHA");
                       while (entrada.hasNext()){ // enquanto não for final do arquivo

                             Integer idEmpresa = entrada.nextInt();
                             String nome = entrada.next();
                             String cnpj = entrada.next();
                             String endereco  = entrada.next();
                             String email  = entrada.next();
                             String senha  = entrada.next();
                           System.out.printf("%8d %-25s %20s %-40s %-50s %-15s\n", idEmpresa, nome, cnpj, endereco, email,senha);
                    }
                    }

                    catch (NoSuchElementException erro){
                        System.out.println("Arquivo com problemas");
                        deuRuim = true;
                    }
                   catch (IllegalStateException erro){
                        System.out.printf("Erro na leitura do arquivo");
                        deuRuim = true;
                    }
                   finally {
                        entrada.close();
                        try {
                            arq.close();
                        }
                      catch (IOException erro){
                           System.out.println("Erro ao fechar o arquivo");
                        deuRuim = true;
                      }
                        if (deuRuim){
                            System.exit(1);
                        }
                   }
             }

    public static void main(String[] args) {

        Integer idEmpresa = 0;
        String nome, cnpj, endereco, email, senha ;
        Boolean fim = false;
        Integer digitado = 0;

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        ListaObj<Empresa> empresa = new ListaObj<>(100);



                 while (!fim){
                     System.out.println("Escolha uma das opções:");
                     System.out.println("1. Adicionar uma Empresa\n" +
                                        "2. Exibir empresas\n" +
                                        "3. Gravar arquivo CSV\n" +
                                        "4. Ler e exibir arquivo CSV\n" +
                                        "5. Buscar empresa\n" +
                                        "6. Fim");
                     System.out.println("Digite um número");
                     digitado = scanner.nextInt();

                            switch (digitado){
                               case 1:
                                    System.out.println("Dígite o ID da Empresa");
                                    idEmpresa = scanner.nextInt();
                                    System.out.println("Dígite o Nome da Empresa");
                                    nome = scanner2.nextLine();
                                    System.out.println("Dígite a CNPJ da Empresa ");
                                    cnpj = scanner2.nextLine();
                                    System.out.println("Dígite o Endereço da Empresa");
                                    endereco = scanner2.nextLine();
                                    System.out.println("Dígite o Email da Empresa");
                                    email = scanner2.nextLine();
                                    System.out.println("Dígite a senha da Empresa");
                                    senha = scanner2.nextLine();
                                    Empresa empresa1 = new Empresa(idEmpresa, nome, cnpj, endereco, email, senha);
                                    empresa.adicionaElemento(empresa1);
                                    break;

                                case 2:
                                   if(empresa.getTamanho().equals(0)) {
                                        System.out.println("Lista está vazia, não há nada para gravar");
                                    }
                                    empresa.exibeLista();
                                    break;

                                case 3:
                                 if(empresa.getTamanho().equals(0)) {
                                        System.out.println("Lista está vazia, não há nada para gravar");
                                   }
                                    gravaArquivoCsv(empresa, "Empresas");
                                    break;

                                case 4:
                                    leExibeArquivoCsv("Empresas");
                                    break;

                               case 5:
                                    System.out.println("Dígite o ID da Empresa que deseja encontrar ");
                                    digitado = scanner.nextInt();

                                     if(empresa.getElemento(idEmpresa).getIdEmpresa().equals(digitado)) {
                                         System.out.println(digitado);
                                    }
                                    System.out.println("Não há nenhuma Empresa com esse Id");
                                   break;

                                case 6:
                                    fim = true;
                                    break;

                                default:
                                    System.out.println("Opção Inválida");

                            }
                        }
    }
}

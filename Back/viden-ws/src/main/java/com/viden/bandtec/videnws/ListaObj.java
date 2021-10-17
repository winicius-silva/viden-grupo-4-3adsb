package com.viden.bandtec.videnws;

public class ListaObj<T> {

    //Atributos
    private T[] vetor;
    private int nroElem;

    //Construtor
    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = nroElem;
    }


    //Métodos
    public boolean adicionaElemento(T elemento){
        if (nroElem >= vetor.length){
            System.out.println("Lista cheia");
            return false;
        }
        vetor[nroElem++] = elemento;
        return true;
    }

    public void exibeLista(){
        for (int i = 0; i < nroElem; i++) {
            System.out.println("\t" + vetor[i]);
        }
    }

    public Integer buscaLista(T elemento){
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public Boolean removePeloIndice(int indice){
        if (indice < 0 || indice >= nroElem){
            return false;
        }
        for (int i = indice; i < nroElem -1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElemento(T elemento){
        return removePeloIndice(buscaLista(elemento));
    }

    public Integer getTamanho(){
        return nroElem;
    }

    public T getElemento(int indice){
        if (indice < 0 || indice >= nroElem){
            return null;
        }
        return vetor[indice];
    }

    public void limpa(){
        nroElem = 0;
    }

}


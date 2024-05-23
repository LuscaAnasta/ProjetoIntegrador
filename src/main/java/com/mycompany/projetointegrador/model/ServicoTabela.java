/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.model;

/**
 *
 * @author lucas
 */
public class ServicoTabela {
    
    public String[] getNomeColunas() {
        return nomeColunas;
    }

    public void setNomeColunas(String[] nomeColunas) {
        this.nomeColunas = nomeColunas;
    }

    public String[][] getDados() {
        return dados;
    }

    public void setDados(String[][] dados) {
        this.dados = dados;
    }

    public ServicoTabela(String[] nomeColunas, String[][] dados) {
        this.nomeColunas = nomeColunas;
        this.dados = dados;
    }
    String[] nomeColunas;
    String[][] dados;
}

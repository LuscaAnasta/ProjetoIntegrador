/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.model;


public class Servico {

   

    public Servico(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Servico(int id) {
        this.id = id;
    }
    
    public Servico(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(int id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    int id;
    String descricao;
    float valor;
}

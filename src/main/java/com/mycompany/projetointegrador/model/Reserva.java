/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.model;


public class Reserva {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public float getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(float valor_servico) {
        this.valor_servico = valor_servico;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    
     public Reserva(int id, String nome_cliente, String cpf_cliente, String nome_funcionario, String descricao_servico, 
             float valor_servico, String horario, String dia) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.cpf_cliente = cpf_cliente;
        this.nome_funcionario = nome_funcionario;
        this.descricao_servico = descricao_servico;
        this.valor_servico = valor_servico;
        this.horario = horario;
        this.dia = dia;
}

    public Reserva(int id_cliente, int id_funcionario, int id_servico, String horario, String dia) {
        this.id_cliente = id_cliente;
        this.id_funcionario = id_funcionario;
        this.id_servico = id_servico;
        this.horario = horario;
        this.dia = dia;
    }

    public Reserva(int id) {
        this.id = id;
    }

    public Reserva(String nome_cliente, String nome_funcionario, String descricao_servico, String horario, String dia) {
        this.nome_cliente = nome_cliente;
        this.nome_funcionario = nome_funcionario;
        this.descricao_servico = descricao_servico;
        this.horario = horario;
        this.dia = dia;
    }
    
    public Reserva(int id_funcionario, int id_servico, String horario, String dia) {
        this.id_funcionario = id_funcionario;
        this.id_servico = id_servico;
        this.horario = horario;
        this.dia = dia;
    }

    public Reserva(int id, int id_cliente, int id_funcionario, int id_servico, String horario, String dia) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_funcionario = id_funcionario;
        this.id_servico = id_servico;
        this.horario = horario;
        this.dia = dia;
    }
    
   
    
    private int id;
    private int id_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private int id_funcionario;
    private String nome_funcionario;
    private int id_servico;
    private String descricao_servico;
    private float valor_servico;
    private String horario;
    private String dia;
}

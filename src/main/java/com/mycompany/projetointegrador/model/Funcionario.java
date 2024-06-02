/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetointegrador.model;


public class Funcionario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Funcionario(int id, String senha){
        this.id = id;
        this.senha = senha;
    }

    public Funcionario(int id) {
        this.id = id;
    }
    

    public Funcionario(String nome, String login, String senha, int telefone, String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }

    public Funcionario(int id, String nome, String login, String senha, int telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }
    

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    private int id;
    private String nome; 
    private String login;
    private String senha; 
    private int telefone; 
    private String email;
}

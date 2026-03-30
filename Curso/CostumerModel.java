package com.example.dados;

public class CostumerModel {
    private int id;
    private String nome;
    private int age;

    public CostumerModel() {
    }

    @Override
    public String toString() {
        return "CostumerModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", age=" + age +
                '}';
    }

    public CostumerModel(int id, String nome, int age) {
        this.id = id;
        this.nome = nome;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.ufcg.psoft.mercadofacil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    
    private Long id;
    private Long cpf;
    private String name;
    private Integer age;
    private String address;
    
    public Client(Long id, Long cpf, String name, Integer age, String address) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    
    
}

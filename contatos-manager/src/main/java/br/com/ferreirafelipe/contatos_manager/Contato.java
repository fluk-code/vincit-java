package br.com.ferreirafelipe.contatos_manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String email;

    private String telefone;

    public Integer getId() {
        return  this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return  this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return  this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return  this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

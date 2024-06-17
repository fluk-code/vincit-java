package br.com.ferreirafelipe.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tarefas_categorias")
public class TarefaCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotBlank(message = "Campo nome é obrigatório!")
    @Size(max = 50, message = "Campo nome deve conter no maximo 50 caracteres!")
    @Column(length = 50)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

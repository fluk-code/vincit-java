package br.com.ferreirafelipe.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@NamedQuery(name = "Tarefa.tarefasPorCategoria", query = "SELECT t FROM Tarefa t INNER JOIN t.categoria c WHERE c.nome = ?1")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "{tarefa.descricao.not-blank}")
    @Size(min = 5, max = 150, message = "{tarefa.descricao.size}")
    @Column(nullable = false, length = 150)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TarefaStatus status = TarefaStatus.ABERTO;

    @FutureOrPresent(message = "{future-or-present}")
    private LocalDate dataEntrega;

    private boolean visivel;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private TarefaCategoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public TarefaCategoria getCategoria() {
        return categoria;
    }

    public void setGategoria(TarefaCategoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}

package br.com.ferreirafelipe.todo.controller.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TarefaRequest {
    @NotNull(message = "{tarefa.descricao.not-null}")
    @Min(value = 1, message = "{tarefa.descricao.min}")
    private Integer id;


    @NotBlank(message = "{tarefa.descricao.not-blank}")
    @Size(min = 5, max = 150, message = "{tarefa.descricao.size}")
    private String descricao;


    @FutureOrPresent(message = "{future-or-present}")
    private LocalDate dataEntrega;

    @NotNull
    @Min(value = 1, message = "{tarefa.descricao.min}")
    private Integer idUsuario;

    @NotNull
    @Min(value = 1, message = "{tarefa.descricao.min}")
    private Integer idCaregtoria;
}

package br.com.ferreirafelipe.todo.services;

import br.com.ferreirafelipe.todo.exception.TarefaStatusException;
import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.model.TarefaStatus;
import br.com.ferreirafelipe.todo.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {
    @InjectMocks
    private TarefaService service;

    @Mock
    private TarefaRepository repository;

    @Test
    void naoDeveConcluirTarefaQuandoCancelada() {
        Tarefa tarefaStub = new Tarefa();
        tarefaStub.setId(1);
        tarefaStub.setStatus(TarefaStatus.CANCELADA);

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(tarefaStub));

        Assertions.assertThrows(TarefaStatusException.class, () -> service.iniciarTarefaPorID(1));
    }
}

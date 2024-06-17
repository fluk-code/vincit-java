package br.com.ferreirafelipe.todo.services;

import br.com.ferreirafelipe.todo.exception.TarefaStatusException;
import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.model.TarefaStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TarefaServiceIntegrationTest {

    @Autowired
    private TarefaService service;

    @Test
    void deveIniciarTarefa(){
        Tarefa tarefa = service.iniciarTarefaPorID(1);

        Assertions.assertEquals(TarefaStatus.EM_ANDAMENTO, tarefa.getStatus());
    }

    @Test
    void naoDeveIniciarTarefaQuandoStatusForConculido(){
        Tarefa tarefa = service.findTarefaById(1);
        tarefa.setStatus(TarefaStatus.CONCULUIDA);
        service.salvarTarefa(tarefa);

        Assertions.assertThrows(TarefaStatusException.class, () -> service.iniciarTarefaPorID(1));
    }

}

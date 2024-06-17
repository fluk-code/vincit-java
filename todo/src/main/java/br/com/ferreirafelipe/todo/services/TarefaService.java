package br.com.ferreirafelipe.todo.services;

import br.com.ferreirafelipe.todo.exception.TarefaStatusException;
import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.model.TarefaStatus;
import br.com.ferreirafelipe.todo.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> listTodasTarefas() {
        return this.repository.findAll();
    }

    public List<Tarefa> listTarefasPorDescricao(String descricao) {
        return this.repository.findByDescricaoLike("%" + descricao + "%");
    }

    public Tarefa findTarefaById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa"));
    }

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return this.repository.save(tarefa);
    }

    public void deleteTarefaById(Integer id) {
        this.repository.deleteById(id);
    }

    public Tarefa iniciarTarefaPorID(Integer id) {
        Tarefa tarefa = findTarefaById(id);

        if(!TarefaStatus.ABERTO.equals(tarefa.getStatus())) {
            throw new TarefaStatusException("Tarefa deve esta no estado de Aberto");
        }

        tarefa.setStatus(TarefaStatus.EM_ANDAMENTO);
        repository.save(tarefa);
        return tarefa;
    }

    public Tarefa concluirTarefaPorId(Integer id) {
        Tarefa tarefa = findTarefaById(id);

        if(!TarefaStatus.EM_ANDAMENTO.equals(tarefa.getStatus())) {
            throw new TarefaStatusException("Tarefa deve esta no estado de Em andamento");
        }

        tarefa.setStatus(TarefaStatus.CONCULUIDA);
        repository.save(tarefa);
        return tarefa;
    }
}

package br.com.ferreirafelipe.todo.controller;

import br.com.ferreirafelipe.todo.controller.request.TarefaRequest;
import br.com.ferreirafelipe.todo.controller.response.TarefaResponse;
import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.services.TarefaService;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/tarefas")
    public List<TarefaResponse> listarTarefas(@RequestParam Map<String,String> params) {
        List<Tarefa> tarefaList = new ArrayList<>();

        if (params.isEmpty()) {
            tarefaList = tarefaService.listTodasTarefas();
        } else {
            String descricao = params.get("descricao");
            tarefaList = tarefaService.listTarefasPorDescricao(descricao);
        }

        List<TarefaResponse> TarefaResponseList = tarefaList
                .stream()
                .map(tarefa -> mapper.map(tarefa, TarefaResponse.class))
                .toList();
                
        return TarefaResponseList;

    }

    @GetMapping("/tarefas/{id}")
    public TarefaResponse tarefaPorID(@PathVariable Integer id) {
        Tarefa tarefa = tarefaService.findTarefaById(id);
        TarefaResponse tarefaResponse = mapper.map(tarefa, TarefaResponse.class);

        return tarefaResponse;
    }

    @PostMapping("/tarefas")
    public TarefaResponse salvarTarefa(@Valid @RequestBody TarefaRequest tarefaReq) {
        Tarefa tarefa = mapper.map(tarefaReq, Tarefa.class);
        tarefa = tarefaService.salvarTarefa(tarefa);
        return mapper.map(tarefa, TarefaResponse.class);
    }

    @DeleteMapping("/tarefas/{id}")
    public void excluirTarefa(@PathVariable Integer id) {
        tarefaService.deleteTarefaById(id);
    }
}

package br.com.ferreirafelipe.todo.repository;

import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
//    List<Tarefa> findByDescricao(String descricao);
    public List<Tarefa> findByDescricaoLike(String descricao);
    public List<Tarefa> findByCategoria(TarefaCategoria categoria);

    @Query("SELECT t FROM Tarefa t INNER JOIN t.categoria c WHERE c.nome = ?1")
    public List<Tarefa> findByNomeCategoria(String nomeCategoria);

    public  List<Tarefa> tarefasPorCategoria(String nomeCategoria);

}


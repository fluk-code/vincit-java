package br.com.ferreirafelipe.todo.repository;

import br.com.ferreirafelipe.todo.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {
}

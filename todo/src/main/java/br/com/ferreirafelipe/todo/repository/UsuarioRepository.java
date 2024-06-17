package br.com.ferreirafelipe.todo.repository;

import br.com.ferreirafelipe.todo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

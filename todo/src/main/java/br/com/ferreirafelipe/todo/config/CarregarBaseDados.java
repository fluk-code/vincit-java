package br.com.ferreirafelipe.todo.config;

import br.com.ferreirafelipe.todo.model.Tarefa;
import br.com.ferreirafelipe.todo.model.TarefaCategoria;
import br.com.ferreirafelipe.todo.model.TarefaStatus;
import br.com.ferreirafelipe.todo.model.Usuario;
import br.com.ferreirafelipe.todo.repository.CategoriaRepository;
import br.com.ferreirafelipe.todo.repository.TarefaRepository;
import br.com.ferreirafelipe.todo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class CarregarBaseDados {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Bean
    CommandLineRunner exec() {
        return args -> {
            Usuario usuario = new Usuario();
            usuario.setNome("Admin");
            usuario.setSenha("123456");

            this.usuarioRepository.save(usuario);

            TarefaCategoria categoria = new TarefaCategoria();
            categoria.setNome("Estudos");

            this.categoriaRepository.save(categoria);

            Tarefa tarefa = new Tarefa();
            tarefa.setDescricao("Aprender SpringBoot");
            tarefa.setDataEntrega(LocalDate.now().plusDays(1));
            tarefa.setStatus(TarefaStatus.ABERTO);
            tarefa.setVisivel(true);
            tarefa.setGategoria(categoria);
            tarefa.setUsuario(usuario);

            this.tarefaRepository.save(tarefa);

            tarefa = new Tarefa();
            tarefa.setDescricao("Aprender Spring Data JPA");
            tarefa.setDataEntrega(LocalDate.now().plusDays(1));
            tarefa.setStatus(TarefaStatus.ABERTO);
            tarefa.setVisivel(true);
            tarefa.setGategoria(categoria);
            tarefa.setUsuario(usuario);

            this.tarefaRepository.save(tarefa);
        };
    }
}

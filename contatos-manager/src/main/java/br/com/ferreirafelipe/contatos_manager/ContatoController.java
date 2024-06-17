package br.com.ferreirafelipe.contatos_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContatoController {
    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/contatos")
    public List<Contato> listarContatos() {
        return  this.contatoRepository.findAll();
    }

    @PostMapping("/contatos")
    public Contato inserirContato(@RequestBody Contato contato) {
        return this.contatoRepository.save(contato);
    }

}

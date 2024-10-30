package br.com.santander.santander_coders.model.service;

import br.com.santander.santander_coders.model.Usuario;
import br.com.santander.santander_coders.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuarioService {

    private final UsuarioRepository repository;

    public ObterUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Não foi possível encontrar usuário com id %s", id)));
    }

}

package br.com.santander.santander_coders.model.service;

import br.com.santander.santander_coders.model.Usuario;
import br.com.santander.santander_coders.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioService {
    private final UsuarioRepository repository;

    public CriarUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario execute(Usuario usuarioQueSeraSalvo) {
        Usuario usuarioPersistido = repository.save(usuarioQueSeraSalvo);
        return usuarioPersistido;
    }
}

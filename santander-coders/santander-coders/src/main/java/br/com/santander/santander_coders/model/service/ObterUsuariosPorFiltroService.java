package br.com.santander.santander_coders.model.service;

import br.com.santander.santander_coders.model.Usuario;
import br.com.santander.santander_coders.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObterUsuariosPorFiltroService {
    private final UsuarioRepository repository;

    public ObterUsuariosPorFiltroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario obterUsuarioPorCpf(String cpf) {
        Optional<Usuario> optionalUsuario = repository.findByCpf(cpf);
        return optionalUsuario.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public List<Usuario> obterUsuarioPorNome(String nomes) {
        return repository.findByNomeContaining(nomes);
    }
}

package br.com.santander.santander_coders.model.repository;

import br.com.santander.santander_coders.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContaining(String nome);

    // derived Query Methods.
    Optional<Usuario> findByCpf(String cpf);
}

package br.com.santander.santander_coders.model.controller;

import br.com.santander.santander_coders.model.Usuario;
import br.com.santander.santander_coders.model.service.CriarUsuarioService;
import br.com.santander.santander_coders.model.service.ObterUsuarioService;
import br.com.santander.santander_coders.model.service.ObterUsuariosPorFiltroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// metodos q o user chama
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService obterUsuarioService;
    private final CriarUsuarioService criarUsuarioService;
    private final ObterUsuariosPorFiltroService obterUsuariosPorFiltro;

    public UsuarioController(ObterUsuarioService obterUsuarioService, CriarUsuarioService criarUsuarioService, ObterUsuariosPorFiltroService obterUsuariosPorFiltro) {
        this.obterUsuarioService = obterUsuarioService;
        this.criarUsuarioService = criarUsuarioService;
        this.obterUsuariosPorFiltro = obterUsuariosPorFiltro;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuarioService.execute(usuario));
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id) {
        return obterUsuarioService.execute(id);
    }

    @GetMapping
    public List<Usuario> obterUsuariosPorNome(@RequestParam String nome) {
        return obterUsuariosPorFiltro.obterUsuarioPorNome(nome);
    }

    @GetMapping("/cpf")
    public Usuario obterUsuariosPorCpf(@RequestParam String cpf) {
        return obterUsuariosPorFiltro.obterUsuarioPorCpf(cpf);
    }
}

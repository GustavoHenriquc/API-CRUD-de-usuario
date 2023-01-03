package com.crudestudo.crud.controller;

import com.crudestudo.crud.models.Usuario;
import com.crudestudo.crud.repositorios.UsuarioRepository;
import com.crudestudo.crud.servicos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;


    @PostMapping(path = "/criar")
    public String criarUsuario(@RequestBody Usuario usuario){ // precisa de um objeto com os dados do usuario
        service.salvaUsuario(usuario);
        return "Usuario criado";
    }

    @GetMapping(path = "/buscaPorId/{id}")
    public Usuario buscarPorId(@PathVariable (name = "id", required = true) Integer id) {
        Usuario usuario = service.buscaPeloId(id).orElseThrow();
        return usuario;
    }

    @GetMapping(path = "/buscatodos")
    public List<Usuario> buscaTodosUsuarios(){
        return repository.findAll();
    }

    @PostMapping(path = "/atualizar/{id}")
    public Usuario atualizarUsuario(@PathVariable (name = "id", required = true) Integer id,
                                    @RequestBody Usuario corpo) { // pego o corpo que é enviado
        return service.atualizaUsuario(id, corpo); //atualizo o usuario com o ID e mostro ele
    }

    @DeleteMapping(path = "/apagaUsuario/{id}")
    public void apagaUsuario(@PathVariable (name = "id", required = true) Integer id) {
        service.deletaUsuario(id); // esse método não retorna, porque como apaga o usuario não da pra retornar ele
    }
}

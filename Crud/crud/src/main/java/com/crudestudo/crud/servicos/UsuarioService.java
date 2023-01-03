package com.crudestudo.crud.servicos;

import com.crudestudo.crud.models.Usuario;
import com.crudestudo.crud.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired //injeção do java
    UsuarioRepository repository;

    //Como o usuario pode não existir, é bom usar opicional

    public Usuario criaUsuario() {
        Usuario usuario = new Usuario(null, "Gustavo", 26, "1234567899", "3799999999");
        repository.save(usuario);
        return usuario;
    }

    public Usuario salvaUsuario(Usuario usuario) {
        repository.save(usuario);
        return usuario;
    }

    public Optional<Usuario> buscaPeloId(Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario;
    }

    public Usuario atualizaUsuario(Integer id, Usuario corpo) {
        Usuario usuario = repository.findById(id).orElseThrow(); // quando é opicional precisa por isso pra se não existir ele não fazer nada
        usuario = corpo;
        repository.save(usuario);
        return usuario;
    }

    public void deletaUsuario (Integer id) {
        Usuario usuario = repository.findById(id).orElseThrow(); //achando um usuario com o ID
        repository.delete(usuario); // apaga ele
        // método void não retorna nada, mas pode retornar uma mensagem de ok por exemplo.
    }


}

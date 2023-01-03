package com.crudestudo.crud.repositorios;

import com.crudestudo.crud.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

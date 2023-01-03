package com.crudestudo.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Usuario {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private Integer idade;
    @Column
    private String cpf;
    @Column
    private String telefone;

}



/*
*   Uma classe pública, pode ser chamada/acessada de qualquer lugar da aplicação
*   por isso, seus CAMPOS são PRIVADOS. Quando os campos do meu Modelo são
*   privados, preciso de MÉTODOS para acessar esses campos pela minha aplicação a fora.
*   MAS, o SpringBoot, juntamente com o LOMBOK, facilita nossa vida, no acesso aos campos.
*
* */

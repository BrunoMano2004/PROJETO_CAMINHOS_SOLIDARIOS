package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nomeCompleto: String,
    val email: String,
    val cpf: String,
    val telefone: String,
    val status: Boolean,
    @JoinColumn(name = "id_endereco")
    @OneToOne(cascade = [CascadeType.REMOVE])
    val endereco: Endereco
)

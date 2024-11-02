package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*

@Entity
data class Endereco(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val logradouro: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val numero: String,
    val cep: String,
    val complemento: String? = null
)

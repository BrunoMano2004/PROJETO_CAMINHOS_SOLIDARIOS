package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.CadastroEnderecoDto
import jakarta.persistence.*

@Entity
data class Endereco(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val logradouro: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val numero: String,
    val cep: String,
    val complemento: String?
){

    constructor(cadastroEndereco: CadastroEnderecoDto): this(
        null,
        cadastroEndereco.logradouro,
        cadastroEndereco.bairro,
        cadastroEndereco.cidade,
        cadastroEndereco.estado,
        cadastroEndereco.numero,
        cadastroEndereco.cep,
        null)
}

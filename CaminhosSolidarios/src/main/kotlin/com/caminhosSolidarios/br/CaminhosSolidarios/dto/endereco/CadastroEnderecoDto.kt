package com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco

data class CadastroEnderecoDto(
    val logradouro: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val numero: String,
    val cep: String,
    val complemento: String? = null)

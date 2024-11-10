package com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco

import com.caminhosSolidarios.br.CaminhosSolidarios.model.Endereco

data class ListagemEnderecoDto(
    val logradouto: String?,
    val bairro: String?,
    val cidade: String?,
    val estado: String?,
    val numero: String?,
    val cep: String?,
    val complemento: String?
){

    constructor(endereco: Endereco?): this(endereco?.logradouro, endereco?.bairro, endereco?.cidade, endereco?.estado, endereco?.numero, endereco?.cep, endereco?.complemento)
}

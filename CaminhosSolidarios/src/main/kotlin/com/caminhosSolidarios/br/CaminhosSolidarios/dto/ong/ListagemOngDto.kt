package com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.ListagemEnderecoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Ong

data class ListagemOngDto(
    val nome: String?,
    val descricao: String?,
    val email: String?,
    val telefone: String?,
    val website: String? = null,
    val enderecoDto: ListagemEnderecoDto
){

    constructor(ong: Ong): this(ong.nome, ong.descricao, ong.email, ong.telefone, ong.website, ListagemEnderecoDto(ong.endereco))
}

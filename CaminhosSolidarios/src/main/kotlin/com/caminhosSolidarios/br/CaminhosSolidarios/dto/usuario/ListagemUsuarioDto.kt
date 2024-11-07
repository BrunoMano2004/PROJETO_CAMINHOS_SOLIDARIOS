package com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.ListagemEnderecoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Usuario

data class ListagemUsuarioDto(
    val nomeCompleto: String,
    val email: String,
    val cpf: String,
    val telefone: String,
    val enderecoDto: ListagemEnderecoDto
){
    constructor(usuario: Usuario): this(usuario.nomeCompleto, usuario.email, usuario.cpf, usuario.telefone, ListagemEnderecoDto(usuario.endereco))
}

package com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.CadastroEnderecoDto

data class CadastroUsuarioDto(
    val nomeCompleto: String,
    val email: String,
    val cpf: String,
    val telefone: String,
    val enderecoDto: CadastroEnderecoDto
)

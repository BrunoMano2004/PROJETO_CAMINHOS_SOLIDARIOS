package com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.CadastroEnderecoDto

data class CadastroOngDto(
    val nome: String,
    val descricao: String,
    val email: String,
    val telefone: String,
    val website: String? = null,
    val enderecoDto: CadastroEnderecoDto
)

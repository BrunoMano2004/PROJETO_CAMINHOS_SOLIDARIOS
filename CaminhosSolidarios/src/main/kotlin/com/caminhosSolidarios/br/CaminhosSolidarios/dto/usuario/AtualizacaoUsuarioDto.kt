package com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario

data class AtualizacaoUsuarioDto(
    val nomeCompleto: String? = null,
    val email: String? = null,
    val cpf: String? = null,
    val telefone: String? = null,
)

package com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.CadastroEnderecoDto
import java.time.LocalDate

data class CadastroProjetoOngDto(
    val nome: String,

    val descricao: String,

    val dataInicio: String,

    val dataFim: String,

    val idOng: Long,

    val endereco: CadastroEnderecoDto
)

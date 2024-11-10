package com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.ListagemEnderecoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Ong
import com.caminhosSolidarios.br.CaminhosSolidarios.model.ProjetoOng
import java.time.LocalDate

data class ListagemProjetoOngDto(

    val nome: String?,

    val descricao: String?,

    val dataInicio: LocalDate?,

    val dataFim: LocalDate?,

    val nomeOng: String?,

    val endereco: ListagemEnderecoDto
){

    constructor(projetoOng: ProjetoOng) : this(projetoOng.nome, projetoOng.descricao, projetoOng.dataInicio, projetoOng.dataFim,
        projetoOng.ong?.nome, ListagemEnderecoDto(projetoOng.endereco))
}

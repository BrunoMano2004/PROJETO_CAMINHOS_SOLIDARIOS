package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class ParticipacaoProjeto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val dataInicio: LocalDate,
    val dataFim: LocalDate? = null,
    val funcaoVoluntario: String,
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    val usuario: Usuario,
    @ManyToOne
    @JoinColumn(name = "id_projeto")
    val projetoOng: ProjetoOng
)

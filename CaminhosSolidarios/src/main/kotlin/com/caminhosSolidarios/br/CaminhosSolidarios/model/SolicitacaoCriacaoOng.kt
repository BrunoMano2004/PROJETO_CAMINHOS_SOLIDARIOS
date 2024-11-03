package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class SolicitacaoCriacaoOng(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val status: Boolean,
    val data: LocalDate,
    val motivo: String,
    @OneToOne
    @JoinColumn(name = "id_ong")
    val ong: Ong
)

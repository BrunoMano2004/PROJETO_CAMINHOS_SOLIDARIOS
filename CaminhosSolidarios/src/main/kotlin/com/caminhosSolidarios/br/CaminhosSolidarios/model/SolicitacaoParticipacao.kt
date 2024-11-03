package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class SolicitacaoParticipacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val status: Boolean,
    val data: LocalDate,
    val motivo: String,
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    val usuario: Usuario,
    @OneToOne
    @JoinColumn(name = "id_participacao_projeto")
    val participacaoProjeto: ParticipacaoProjeto
)

package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class ProjetoOng(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val descricao: String,
    val dataInicio: LocalDate,
    val dataFim: LocalDate? = null,
    @ManyToOne
    @JoinColumn(name = "id_ong")
    val ong: Ong,
    @OneToOne
    @JoinColumn(name = "id_endereco")
    val endereco: Endereco,
    @OneToMany(mappedBy = "projetoOng", fetch = FetchType.LAZY)
    val participantes: List<ParticipacaoProjeto> = emptyList()
)

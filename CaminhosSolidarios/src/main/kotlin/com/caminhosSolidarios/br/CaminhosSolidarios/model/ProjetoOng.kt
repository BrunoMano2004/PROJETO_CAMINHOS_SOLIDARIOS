package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class ProjetoOng {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val nome: String? = null

    val descricao: String? = null

    val dataInicio: LocalDate? = null

    val dataFim: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "id_ong")
    val ong: Ong? = null

    @OneToOne
    @JoinColumn(name = "id_endereco")
    val endereco: Endereco? = null

    @OneToMany(mappedBy = "projetoOng", fetch = FetchType.LAZY)
    val participantes: List<ParticipacaoProjeto> = emptyList()

}
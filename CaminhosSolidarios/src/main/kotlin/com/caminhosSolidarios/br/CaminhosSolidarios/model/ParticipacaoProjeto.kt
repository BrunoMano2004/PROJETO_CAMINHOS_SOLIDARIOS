package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
class ParticipacaoProjeto{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val dataInicio: LocalDate = LocalDate.now()

    val dataFim: LocalDate? = null

    var funcaoVoluntario: String? = null

    var status: Boolean = false

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario? = null

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    var projetoOng: ProjetoOng? = null
}

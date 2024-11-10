package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class SolicitacaoParticipacao{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val status: Status = Status.PENDENTE

    val data: LocalDate = LocalDate.now()

    val motivo: String? = null

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario? = null

    @OneToOne
    @JoinColumn(name = "id_participacao_projeto")
    var participacaoProjeto: ParticipacaoProjeto? = null
}

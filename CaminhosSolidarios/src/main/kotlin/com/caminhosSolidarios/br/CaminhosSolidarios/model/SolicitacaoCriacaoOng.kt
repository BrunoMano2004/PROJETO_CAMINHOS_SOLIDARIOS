package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class SolicitacaoCriacaoOng {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: Status = Status.PENDENTE

    val data: LocalDateTime = LocalDateTime.now()

    var motivo: String? = null

    @OneToOne
    @JoinColumn(name = "id_ong")
    var ong: Ong? = null

    constructor(ong: Ong){
        this.ong = ong
    }
}

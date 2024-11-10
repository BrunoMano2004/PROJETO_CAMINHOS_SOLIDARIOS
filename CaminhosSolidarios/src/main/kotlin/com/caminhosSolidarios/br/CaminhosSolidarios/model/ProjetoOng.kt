package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng.CadastroProjetoOngDto
import jakarta.persistence.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Entity
class ProjetoOng {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var nome: String? = null

    var descricao: String? = null

    var dataInicio: LocalDate? = null

    var dataFim: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "id_ong")
    var ong: Ong? = null

    @OneToOne
    @JoinColumn(name = "id_endereco")
    var endereco: Endereco? = null

    @OneToMany(mappedBy = "projetoOng", fetch = FetchType.LAZY)
    val participantes: List<ParticipacaoProjeto> = emptyList()

    constructor(projetoDto: CadastroProjetoOngDto){
        val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        this.nome = projetoDto.nome
        this.descricao = projetoDto.descricao
        this.dataInicio = LocalDate.parse(projetoDto.dataInicio, dtf)
        this.dataFim = LocalDate.parse(projetoDto.dataFim, dtf)
    }
}
package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.CadastroOngDto
import jakarta.persistence.*

@Entity
class Ong {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var nome: String? = null

    var descricao: String? = null

    var email: String? = null

    var telefone: String? = null

    var website: String? = null

    var status: Boolean = false

    @OneToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "id_endereco")
    lateinit var endereco: Endereco

    @OneToMany(mappedBy = "ong", fetch = FetchType.LAZY)
    val projetos: List<ProjetoOng> = emptyList()

    constructor(cadastroOng: CadastroOngDto){
        this.nome = cadastroOng.nome
        this.descricao = cadastroOng.descricao
        this.email = cadastroOng.email
        this.telefone = cadastroOng.telefone
        this.website = cadastroOng.website
    }
}

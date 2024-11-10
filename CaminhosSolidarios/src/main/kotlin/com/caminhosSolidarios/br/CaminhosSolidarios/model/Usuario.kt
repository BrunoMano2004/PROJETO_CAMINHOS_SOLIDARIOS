package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.AtualizacaoUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.CadastroUsuarioDto
import jakarta.persistence.*

@Entity
class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var nomeCompleto: String? = null

    var email: String? = null

    var cpf: String? = null

    var telefone: String? = null

    var status: Boolean = true

    @JoinColumn(name = "id_endereco")
    @OneToOne(cascade = [CascadeType.REMOVE])
    lateinit var endereco: Endereco

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val postagens: List<BlogPost> = emptyList()

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val participacoesProjetos: List<ParticipacaoProjeto> = emptyList()

    constructor(cadastroUsuario: CadastroUsuarioDto){
        this.nomeCompleto = cadastroUsuario.nomeCompleto
        this.email = cadastroUsuario.email
        this.cpf = cadastroUsuario.cpf
        this.telefone = cadastroUsuario.telefone
    }

    fun atualizar(atualizacaoUsuario: AtualizacaoUsuarioDto){
        if (atualizacaoUsuario.nomeCompleto != null){
            this.nomeCompleto = atualizacaoUsuario.nomeCompleto
        }

        if (atualizacaoUsuario.email != null){
            this.email = atualizacaoUsuario.email
        }

        if (atualizacaoUsuario.cpf != null){
            this.cpf = atualizacaoUsuario.cpf
        }

        if (atualizacaoUsuario.telefone != null){
            this.telefone = atualizacaoUsuario.telefone
        }
    }
}

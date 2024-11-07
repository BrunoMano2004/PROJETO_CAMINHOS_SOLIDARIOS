package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.AtualizacaoUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.CadastroUsuarioDto
import jakarta.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nomeCompleto: String,
    var email: String,
    var cpf: String,
    var telefone: String,
    var status: Boolean = true,
){

    @JoinColumn(name = "id_endereco")
    @OneToOne(cascade = [CascadeType.REMOVE])
    lateinit var endereco: Endereco

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val postagens: List<BlogPost> = emptyList()

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val participacoesProjetos: List<ParticipacaoProjeto> = emptyList()

    constructor(cadastroUsuario: CadastroUsuarioDto): this(null, cadastroUsuario.nomeCompleto, cadastroUsuario.email, cadastroUsuario.cpf, cadastroUsuario.telefone)

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

package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nomeCompleto: String,
    val email: String,
    val cpf: String,
    val telefone: String,
    val status: Boolean,
    @JoinColumn(name = "id_endereco")
    @OneToOne(cascade = [CascadeType.REMOVE])
    val endereco: Endereco,
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val postagens: List<BlogPost> = emptyList(),
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    val participacoesProjetos: List<ParticipacaoProjeto> = emptyList()
)

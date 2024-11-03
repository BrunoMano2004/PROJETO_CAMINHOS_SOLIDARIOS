package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*

@Entity
data class Ong(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val descricao: String,
    val email: String,
    val telefone: String,
    val website: String? = null,
    val status: Boolean,
    @OneToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "id_endereco")
    val endereco: Endereco,
    @OneToMany(mappedBy = "ong", fetch = FetchType.LAZY)
    val projetos: List<ProjetoOng> = emptyList()
)

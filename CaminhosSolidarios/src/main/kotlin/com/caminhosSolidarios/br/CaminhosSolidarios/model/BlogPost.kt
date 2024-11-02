package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class BlogPost(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val titulo: String,
    val conteudo: String,
    val data_publi: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    val usuario: Usuario
)

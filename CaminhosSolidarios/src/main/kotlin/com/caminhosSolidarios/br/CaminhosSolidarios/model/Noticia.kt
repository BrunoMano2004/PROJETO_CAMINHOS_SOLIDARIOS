package com.caminhosSolidarios.br.CaminhosSolidarios.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Noticia(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val titulo: String,
    val conteudo: String,
    val dataPubli: LocalDateTime,
    val imagemUrl: String
)

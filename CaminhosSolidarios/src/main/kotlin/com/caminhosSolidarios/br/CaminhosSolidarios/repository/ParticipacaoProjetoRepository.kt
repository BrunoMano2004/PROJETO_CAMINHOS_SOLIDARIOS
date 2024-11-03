package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.ParticipacaoProjeto
import org.springframework.data.jpa.repository.JpaRepository

interface ParticipacaoProjetoRepository: JpaRepository<ParticipacaoProjeto, Long> {
}
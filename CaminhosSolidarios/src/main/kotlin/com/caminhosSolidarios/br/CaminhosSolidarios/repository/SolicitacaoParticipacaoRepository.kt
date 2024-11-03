package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.SolicitacaoParticipacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SolicitacaoParticipacaoRepository: JpaRepository<SolicitacaoParticipacao, Long> {
}
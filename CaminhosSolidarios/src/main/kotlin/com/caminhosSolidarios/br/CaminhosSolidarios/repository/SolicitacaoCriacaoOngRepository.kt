package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.SolicitacaoCriacaoOng
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SolicitacaoCriacaoOngRepository: JpaRepository<SolicitacaoCriacaoOng, Long> {
}
package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.Ong
import com.caminhosSolidarios.br.CaminhosSolidarios.model.SolicitacaoCriacaoOng
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SolicitacaoCriacaoOngRepository: JpaRepository<SolicitacaoCriacaoOng, Long> {

    fun findByOng(ong: Ong): Optional<SolicitacaoCriacaoOng>
}
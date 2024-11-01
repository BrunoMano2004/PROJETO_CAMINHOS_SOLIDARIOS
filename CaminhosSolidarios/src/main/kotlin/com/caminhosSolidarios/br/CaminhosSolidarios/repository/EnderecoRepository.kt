package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Long> {
}
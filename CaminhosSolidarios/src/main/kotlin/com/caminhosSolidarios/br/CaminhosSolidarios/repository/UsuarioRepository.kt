package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long>{
}
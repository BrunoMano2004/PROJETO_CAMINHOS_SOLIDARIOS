package com.caminhosSolidarios.br.CaminhosSolidarios.repository

import com.caminhosSolidarios.br.CaminhosSolidarios.model.BlogPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogPostRespository: JpaRepository<BlogPost, Long> {
}
package com.caminhosSolidarios.br.CaminhosSolidarios.controller

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.AnaliseSolicitacaoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.service.SolicitacaoCriacaoOngService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(
    private val solicitacaoService: SolicitacaoCriacaoOngService
) {

    @PostMapping("/aprovarOng")
    @Transactional
    fun aprovarCriacaoOng(@RequestBody solicitacaoDto: AnaliseSolicitacaoDto): ResponseEntity<String>{
        solicitacaoService.aprovarSolicitacao(solicitacaoDto)
        return ResponseEntity("Solicitação aprovada!", HttpStatus.OK)
    }

    @PostMapping("/negarOng")
    @Transactional
    fun negarCriacaoOng(@RequestBody solicitacaoDto: AnaliseSolicitacaoDto){
        solicitacaoService.negarSolicitacao(solicitacaoDto)
    }
}
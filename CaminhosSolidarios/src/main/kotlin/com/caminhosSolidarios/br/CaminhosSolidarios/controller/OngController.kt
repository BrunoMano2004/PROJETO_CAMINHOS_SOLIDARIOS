package com.caminhosSolidarios.br.CaminhosSolidarios.controller

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.CadastroOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.ListagemOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.service.OngService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ong")
class OngController(
    private val ongService: OngService
) {

    @PostMapping("/cadastrar")
    fun cadastrarOng(@RequestBody ongDto: CadastroOngDto): ResponseEntity<String>{
        ongService.cadastrarOng(ongDto)
        return ResponseEntity("Ong cadastrada! Aguardando aprovação dos admins!", HttpStatus.CREATED)
    }

    @GetMapping("/listar/{id}")
    fun listarDadosOng(@PathVariable id: Long): ResponseEntity<ListagemOngDto>{
        val ongDto = ongService.listarDadosOng(id)
        return ResponseEntity(ongDto, HttpStatus.OK)
    }
}
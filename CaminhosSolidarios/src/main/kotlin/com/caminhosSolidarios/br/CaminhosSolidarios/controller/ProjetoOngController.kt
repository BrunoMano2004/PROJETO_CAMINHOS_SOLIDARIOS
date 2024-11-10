package com.caminhosSolidarios.br.CaminhosSolidarios.controller

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng.CadastroProjetoOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng.ListagemProjetoOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.service.ProjetoOngService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projetoOng")
class ProjetoOngController(
    private val projetoService: ProjetoOngService
) {

    @PostMapping("/cadastrar")
    fun cadastrarProjeto(@RequestBody projetoDto: CadastroProjetoOngDto): ResponseEntity<String>{
        projetoService.cadastrarProjeto(projetoDto)
        return ResponseEntity("Projeto criado com sucesso!", HttpStatus.CREATED)
    }

    @GetMapping("/listar/{idProjeto}")
    fun listarDadosProjeto(@PathVariable idProjeto: Long): ResponseEntity<ListagemProjetoOngDto>{
        val listagemProjeto = projetoService.listarDadosOng(idProjeto)
        return ResponseEntity(listagemProjeto, HttpStatus.OK)
    }

    @GetMapping("/listarTodos/{idOng}")
    fun listarTodosProjetosDeUmaOng(@PathVariable idOng: Long): ResponseEntity<List<ListagemProjetoOngDto>>{
        val listaDeProjetos = projetoService.listarTodosProjetoDeUmaOng(idOng)
        return ResponseEntity(listaDeProjetos, HttpStatus.OK)
    }
}
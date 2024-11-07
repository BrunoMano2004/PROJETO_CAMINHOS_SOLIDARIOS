package com.caminhosSolidarios.br.CaminhosSolidarios.controller

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.AtualizacaoUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.CadastroUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.ListagemUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.service.UsuarioService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val usuarioService: UsuarioService
) {

    @PostMapping("/cadastro")
    fun cadastroUsuario(@RequestBody cadastroUsuario: CadastroUsuarioDto): ResponseEntity<String>{
        usuarioService.criarUsuario(cadastroUsuario)
        return ResponseEntity("", HttpStatus.CREATED)
    }

    @GetMapping("/listar/{id}")
    fun listarDadosDeUmUsuário(@PathVariable id: Long): ResponseEntity<ListagemUsuarioDto>{
        val usuario = usuarioService.listarDadosUsuario(id)
        return ResponseEntity(usuario, HttpStatus.OK)
    }

    @PatchMapping("/atuializar/{id}")
    @Transactional
    fun atualizarUsuario(@PathVariable id: Long,
                         @RequestBody atualizacaoUsuario: AtualizacaoUsuarioDto): ResponseEntity<String>
    {
        usuarioService.atualizarDadosUsuario(atualizacaoUsuario)
        return ResponseEntity("Usuário atualizado com sucesso!", HttpStatus.OK)
    }
}
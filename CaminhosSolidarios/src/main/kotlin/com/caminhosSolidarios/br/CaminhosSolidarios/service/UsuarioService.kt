package com.caminhosSolidarios.br.CaminhosSolidarios.service

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.AtualizacaoUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.CadastroUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.usuario.ListagemUsuarioDto
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.ResourceNotFoundException
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Endereco
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Usuario
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.EnderecoRepository
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val enderecoRepository: EnderecoRepository
) {

    fun criarUsuario(usuarioDto: CadastroUsuarioDto){
        val endereco = Endereco(usuarioDto.enderecoDto)
        enderecoRepository.save(endereco)
        val usuario = Usuario(usuarioDto)
        usuario.endereco = endereco
        usuarioRepository.save(usuario)
    }

    fun listarDadosUsuario(id: Long): ListagemUsuarioDto{
        val usuario = usuarioRepository.findById(id).orElseThrow{
            ResourceNotFoundException("Usuário não encontrado!")
        }
        return ListagemUsuarioDto(usuario)
    }

    fun atualizarDadosUsuario(id: Long, atualizacaoUsuario: AtualizacaoUsuarioDto){
        val usuario = usuarioRepository.findById(id).orElseThrow{
            ResourceNotFoundException("Usuário não encontrado!")
        }
        usuario.atualizar(atualizacaoUsuario)
    }
}
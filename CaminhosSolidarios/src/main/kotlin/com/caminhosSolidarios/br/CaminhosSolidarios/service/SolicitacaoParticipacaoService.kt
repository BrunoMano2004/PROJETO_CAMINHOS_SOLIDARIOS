package com.caminhosSolidarios.br.CaminhosSolidarios.service

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.solicitacaoParticipacao.CadastroSolicitacaoParticipacaoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.ResourceNotFoundException
import com.caminhosSolidarios.br.CaminhosSolidarios.model.ParticipacaoProjeto
import com.caminhosSolidarios.br.CaminhosSolidarios.model.SolicitacaoParticipacao
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.*
import org.springframework.stereotype.Service

@Service
class SolicitacaoParticipacaoService(
    private val solicitacaoRepository: SolicitacaoParticipacaoRepository,
    private val usuarioRepository: UsuarioRepository,
    private val projetoOngRepository: ProjetoOngRepository,
    private val participacaoRepository: ParticipacaoProjetoRepository
) {

    fun cadastrarSolicitacao(solicitacaoDto: CadastroSolicitacaoParticipacaoDto){
        val usuario = usuarioRepository.findById(solicitacaoDto.idUsuario).orElseThrow{
            ResourceNotFoundException("Usuário não encontrado!")
        }

        val projetoOng = projetoOngRepository.findById(solicitacaoDto.idProjeto).orElseThrow{
            ResourceNotFoundException("Projeto não encontrado!")
        }

        val participacaoProjeto = ParticipacaoProjeto().apply {
            this.funcaoVoluntario = projetoOng.nome
            this.projetoOng = projetoOng
            this.usuario = usuario
        }

        participacaoRepository.save(participacaoProjeto)

        val solicitacao = SolicitacaoParticipacao().apply {
            this.usuario = usuario
            this.participacaoProjeto = participacaoProjeto
        }

        solicitacaoRepository.save(solicitacao)
    }
}
package com.caminhosSolidarios.br.CaminhosSolidarios.service

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.AnaliseSolicitacaoDto
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.InvalidDataException
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.ResourceNotFoundException
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Ong
import com.caminhosSolidarios.br.CaminhosSolidarios.model.SolicitacaoCriacaoOng
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Status
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.OngRepository
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.SolicitacaoCriacaoOngRepository
import org.springframework.stereotype.Service

@Service
class SolicitacaoCriacaoOngService(
    private val solicitacaoOngRepository: SolicitacaoCriacaoOngRepository,
    private val ongRepository: OngRepository
) {

    fun solicitarCriacaoOng(ong: Ong){
        val solicitacao = SolicitacaoCriacaoOng(ong)
        solicitacaoOngRepository.save(solicitacao)
    }

    fun aprovarSolicitacao(solicitacaoDto: AnaliseSolicitacaoDto){

        val solicitacao = verificarSeOngESolicitacaoExistem(solicitacaoDto)

        solicitacao.apply {
            this.status = Status.APROVADO
            this.motivo = solicitacaoDto.motivo
            this.ong?.status ?: true
        }
    }

    fun negarSolicitacao(solicitacaoDto: AnaliseSolicitacaoDto) {

        val solicitacao = verificarSeOngESolicitacaoExistem(solicitacaoDto)

        solicitacao.apply {
            this.status = Status.NEGADO
            this.motivo = solicitacaoDto.motivo
        }
    }

    private fun verificarSeOngESolicitacaoExistem(solicitacaoDto: AnaliseSolicitacaoDto): SolicitacaoCriacaoOng{
        val ong = ongRepository.findById(solicitacaoDto.idOng).orElseThrow{
            ResourceNotFoundException("Ong não encontrada!")
        }

        val solicitacao = solicitacaoOngRepository.findByOng(ong).orElseThrow{
            ResourceNotFoundException("Solicitação não encontrada!")
        }

        if (solicitacao.status == Status.PENDENTE){
            return solicitacao
        } else {
            throw InvalidDataException("Status da solicitação já definido")
        }
    }
}
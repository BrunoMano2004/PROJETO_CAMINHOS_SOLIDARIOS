package com.caminhosSolidarios.br.CaminhosSolidarios.service

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng.CadastroProjetoOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.projetoOng.ListagemProjetoOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.InvalidRequestException
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.ResourceNotFoundException
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Endereco
import com.caminhosSolidarios.br.CaminhosSolidarios.model.ProjetoOng
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.EnderecoRepository
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.OngRepository
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.ProjetoOngRepository
import org.springframework.stereotype.Service

@Service
class ProjetoOngService(
    private val projetoRepository: ProjetoOngRepository,
    private val ongRepository: OngRepository,
    private val enderecoRepository: EnderecoRepository
) {

    fun cadastrarProjeto(cadastroProjetoDto: CadastroProjetoOngDto){
        val ong = ongRepository.findById(cadastroProjetoDto.idOng).orElseThrow{
            ResourceNotFoundException("Ong não encontrada!")
        }

        if (ong.status){
            val projetoOng = ProjetoOng(cadastroProjetoDto)
            val endereco = Endereco(cadastroProjetoDto.endereco)

            enderecoRepository.save(endereco)

            projetoOng.apply {
                this.endereco = endereco
                this.ong = ong
            }

            projetoRepository.save(projetoOng)

        } else {
            throw InvalidRequestException("Ong ainda não aprovada pelos admins! Pro gentileza, aguarde aprovação")
        }
    }

    fun listarDadosOng(idProjeto: Long): ListagemProjetoOngDto{
        val projetoOng = projetoRepository.findById(idProjeto).orElseThrow{
            ResourceNotFoundException("Projeto não encontrado!")
        }

        return ListagemProjetoOngDto(projetoOng)
    }

    fun listarTodosProjetoDeUmaOng(idOng: Long): List<ListagemProjetoOngDto>{
        val ong = ongRepository.findById(idOng).orElseThrow{
            ResourceNotFoundException("Ong não encontrada!")
        }

        val listaDeProjetos = ong.projetos.map {
            ListagemProjetoOngDto(it)
        }

        return listaDeProjetos
    }
}
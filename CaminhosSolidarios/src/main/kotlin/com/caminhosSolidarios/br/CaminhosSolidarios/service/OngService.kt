package com.caminhosSolidarios.br.CaminhosSolidarios.service

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.CadastroOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.dto.ong.ListagemOngDto
import com.caminhosSolidarios.br.CaminhosSolidarios.exception.ResourceNotFoundException
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Endereco
import com.caminhosSolidarios.br.CaminhosSolidarios.model.Ong
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.EnderecoRepository
import com.caminhosSolidarios.br.CaminhosSolidarios.repository.OngRepository
import org.springframework.stereotype.Service

@Service
class OngService(
    private val ongRepository: OngRepository,
    private val solicitacaoCriacaoOng: SolicitacaoCriacaoOngService,
    private val enderecoRepository: EnderecoRepository
) {

    fun cadastrarOng(cadastroOng: CadastroOngDto){
        val endereco = Endereco(cadastroOng.enderecoDto)
        enderecoRepository.save(endereco)
        val ong = Ong(cadastroOng)
        ong.endereco = endereco
        ongRepository.save(ong)
        solicitacaoCriacaoOng.solicitarCriacaoOng(ong)
    }

    fun listarDadosOng(id: Long): ListagemOngDto{
        val ong = ongRepository.findById(id).orElseThrow{
            ResourceNotFoundException("Ong não encontrada!")
        }

        return ListagemOngDto(ong)
    }
}
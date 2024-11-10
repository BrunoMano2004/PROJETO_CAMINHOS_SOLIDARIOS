package com.caminhosSolidarios.br.CaminhosSolidarios.model

import com.caminhosSolidarios.br.CaminhosSolidarios.dto.endereco.CadastroEnderecoDto
import jakarta.persistence.*

@Entity
class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var logradouro: String? = null

    var bairro: String? = null

    var cidade: String? = null

    var estado: String? = null

    var numero: String? = null

    var cep: String? = null

    var complemento: String? = null

    constructor(cadastroEndereco: CadastroEnderecoDto){
        this.logradouro = cadastroEndereco.logradouro
        this.bairro = cadastroEndereco.bairro
        this.cidade = cadastroEndereco.cidade
        this.estado = cadastroEndereco.estado
        this.numero = cadastroEndereco.numero
        this.cep = cadastroEndereco.cep
        this.complemento = cadastroEndereco.complemento
    }
}

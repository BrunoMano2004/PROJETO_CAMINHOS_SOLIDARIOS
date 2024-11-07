package com.caminhosSolidarios.br.CaminhosSolidarios.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun tratarResourceNotFound(ex: ResourceNotFoundException): ResponseEntity<String>{
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}
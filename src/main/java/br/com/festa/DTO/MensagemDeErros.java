package br.com.festa.DTO;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus Status,String mensagem) {

}

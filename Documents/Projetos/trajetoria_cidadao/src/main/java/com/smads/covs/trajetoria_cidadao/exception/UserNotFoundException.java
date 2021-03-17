package com.smads.covs.trajetoria_cidadao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "cidadão não encontrado no banco de dados")
public class UserNotFoundException extends RuntimeException{
}

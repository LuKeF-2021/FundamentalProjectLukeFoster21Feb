package com.qa.fundamentalProject.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Champion does not exist with that ID")
public class ChampionNotFoundException extends EntityNotFoundException{
	
}

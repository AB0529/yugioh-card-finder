package com.ab0529.yugioh_card_finder.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(value = {SQLException.class})
    public String databaseError() {
        return "DB Error";
    }
}

package com.spring.boot.coffeine.controller;

import com.spring.boot.coffeine.exception.CoffeineException;
import com.spring.boot.coffeine.model.Error;
import com.spring.boot.coffeine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class BaseController {
    @Autowired
    ValidateService validateService;

}

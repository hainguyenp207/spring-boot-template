package com.spring.boot.coffeine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ValidateService extends AbstractService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateService.class);

    @Autowired
    ValidateService(Environment environment) {
        super(environment);
    }


}

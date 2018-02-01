package com.spring.boot.coffeine.service;

import com.spring.boot.coffeine.dao.reponsitories.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public UserService(Environment env) {
        super(env);
    }


}

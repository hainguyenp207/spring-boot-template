package com.spring.boot.coffeine.service;


import com.google.gson.Gson;
import com.spring.boot.coffeine.dao.reponsitories.AccountRepository;
import com.spring.boot.coffeine.dao.reponsitories.CoffeineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class AbstractService {
    protected Environment env;

    private Gson gson;

    @Autowired
    AccountRepository accountRepository;



    AbstractService(Environment env){
        this.env = env;
    }

    public Gson getGson() {
     return new Gson();
    }

}

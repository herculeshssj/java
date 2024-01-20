package br.dev.hssj.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public abstract class AbstractCoach {

    @PostConstruct
    public void postConstructBean() {
        System.out.println("In post construction bean: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroyBean() {
        System.out.println("In pre destroy bean: " + getClass().getSimpleName());
    }
}

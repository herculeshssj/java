package br.dev.hssj.springcoredemo.config;

import br.dev.hssj.springcoredemo.common.Coach;
import br.dev.hssj.springcoredemo.common.SwimgCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean(name = "aquatic")
    public Coach swingCoach() {
        return new SwimgCoach();
    }
}

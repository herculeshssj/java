package br.dev.hssj.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Util {
    public String today() {
        return LocalDateTime.now().toString();
    }
}

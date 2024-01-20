package br.dev.hssj.springcoredemo.common;

public class SwimgCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}

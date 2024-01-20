package br.dev.hssj.springcoredemo.rest;

import br.dev.hssj.springcoredemo.common.Coach;
import br.dev.hssj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Util util; // this way of injection is not recommended by Spring Team
    // This way make the code harder to unit test
    private Coach myCoach;
    private Coach anotherCoach;

    public DemoController() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }


    // dependency injection by constructor
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        this.myCoach = theCoach;
    }


    /*
    // dependency injection by setter method
    @Autowired
    public void setMyCoach(@Qualifier("tennisCoach") Coach theCoach) {
        // The primary implementation of Coach interface is TrackCoach.
        // This default setting is possible through @Primary annotation
        this.myCoach = theCoach;
    }
     */

    public void setAnotherCoach(@Qualifier("cricketCoach") Coach anotherCoach) {
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/today")
    public String getToday() {
        return util.today();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}

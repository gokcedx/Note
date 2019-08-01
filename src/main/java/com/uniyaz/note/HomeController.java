package com.uniyaz.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kübra VARICI
 */
@RestController
public class HomeController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/deneme")
    public String home() {
        return greetingService.greet();
    }
}

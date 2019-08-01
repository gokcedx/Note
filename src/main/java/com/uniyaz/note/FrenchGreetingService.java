package com.uniyaz.note;

/**
 * @author Kübra VARICI
 */
public class FrenchGreetingService  implements GreetingService {

    @Override
    public String greet() {
        return "Bonjour Monde!";
    }
}

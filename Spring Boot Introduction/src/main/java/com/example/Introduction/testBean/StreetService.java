package com.example.Introduction.testBean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class StreetService {
    private final Animal dog;
    private final Animal cat;

    public StreetService(Animal dog, Animal cat) {
        this.dog = dog;
        this.cat = cat;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct of StreetService: ...");
        this.cat.makeSound();
        this.dog.makeSound();
        System.out.println(this.cat.hashCode());
        System.out.println(this.dog.hashCode());
    }
}

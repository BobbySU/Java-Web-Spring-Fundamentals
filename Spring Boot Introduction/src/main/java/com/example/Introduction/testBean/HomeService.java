package com.example.Introduction.testBean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

//    private final Animal animal;
//
//    @Autowired
//    public HomeService(@Qualifier("dog") Animal animal) {
//        this.animal = animal;
//        this.animal.makeSound();
//    }

    private final Animal dog;
    private final Animal cat;
    private final Animal animal;
    private final List<Animal> animals;

    @Autowired
    public HomeService(Animal dog, Animal cat, @Qualifier("cat") Animal animal, List<Animal> animals) {
        this.dog = dog;
        this.cat = cat;
        this.animal = animal;
        this.animals = animals;
        System.out.println("HomeService: ...");
        this.dog.makeSound();
        this.animal.makeSound();
        System.out.println("HomeService - List<E>: ...");
        this.animals.forEach(Animal::makeSound);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct of home: ...");
        this.cat.makeSound();
        this.dog.makeSound();
        System.out.println(this.cat.hashCode());
        System.out.println(this.dog.hashCode());
        System.out.println("list of animals activities: ...");
        this.animals.forEach(Animal::makeSound);
    }
}

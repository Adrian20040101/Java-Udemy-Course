package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Animal animal = new Animal("Animal", "big", 100);  ->won't compile since we cannot instantiate abstract classes
        Dog dog = new Dog("Wolf", "big", 100);
        Fish fish = new Fish("Clownfish", "small", 1);
        //we can create an ArrayList of animals and see their different behaviour based on their type
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(fish);
        //add some more animals
        animals.add(new Dog("Labrador", "big", 75));
        animals.add(new Dog("Pug", "small", 25));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Horse("Clydesdale", "big", 300));

        //check out their behaviour based on their type -> that's where the advantages of abstract class really shine
        for (Animal animal : animals){
            doAnimalStuff(animal);
            if (animal instanceof Mammal mammal){
                mammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal){
        animal.move("slow");
        animal.makeNoise();
    }
}

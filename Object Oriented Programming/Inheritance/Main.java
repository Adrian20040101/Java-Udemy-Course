public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Zebra", "medium", 65);
        Dog dog = new Dog("Labrador", 60,"fast", "fluffy", "swimmer");
        Fish fish = new Fish("Clownfish", "small", 0.25, 3, 4);
        animal.doAnimalStuff();
        animal.makeNoise();
        System.out.println(animal);  //when typing this line of code, Java automatically calls the toString method
        System.out.println("---------------------");
        dog.doAnimalStuff();
        dog.makeNoise();
        dog.playing();  //this method is specific for the dog class, therefore not accessible by the animal class
        System.out.println(dog);
        System.out.println("---------------------");
        fish.doAnimalStuff();
        fish.makeNoise();  //we can see that if we don't override this method in fish class, it will print the content from the animal class
        fish.location();  //this method is specific for the fish class, therefore not accessible by the animal class
        System.out.println(fish);
        System.out.println("---------------------");

    }
}

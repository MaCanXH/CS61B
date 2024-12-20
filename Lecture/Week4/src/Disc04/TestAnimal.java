package Disc04;

public class TestAnimal {
    public static void main(String[] args) {
//        Animal hunman = new Animal("Ken", 4);
//        Cat kitty = new Cat("kitty", 4);
//
//        hunman.greet();
//        kitty.greet();
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfeld" , 6);
        Dog d = new Dog("Fido", 4);
        a.greet();  /* Huh? */
        c.greet();  /* Meow! */
        d.greet(); /* WOOF! */
        a = c;
        ((Cat) a).greet(); /* Meow! */
        a.greet(); /* Meow! */
    }

    Dog a = new Dog("Spot", 10);
    Dog d = a;
}


package ProjectI.StructuralPattern;

// Animal Interface
interface Animal {
    void speak();
}

// Concrete Product - Dog
class Cow implements Animal {
    @Override
    public void speak() {
        System.out.println("Moo");
    }
}

// Concrete Product - Cat
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

// Factory
class AnimalFactory {
    public static Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("Cow")) {
            return new Cow();
        } else {
            return null;
        }
    }
}

// Main
public class FactoryPattern {
    public static void main(String[] args) {
        Animal Jersey = AnimalFactory.createAnimal("Cow");
        Jersey.speak();

        Animal Pomeranian = AnimalFactory.createAnimal("Dog");
        Pomeranian.speak();
    }
}

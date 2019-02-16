package te.interview.prep.stacks_queues;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelter {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();

    public void enqueue(Pet pet) {
        pet.setArrivalTime(LocalDateTime.now());

        if (pet instanceof Dog) dogs.addFirst((Dog) pet);
        if (pet instanceof Cat) cats.addFirst((Cat) pet);
    }

    public Pet dequeueAny() {
        if(dogs.isEmpty() && cats.isEmpty()) throw new NoSuchElementException("Animal Shelter is empty!");

        if(dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else {
            LocalDateTime oldestDogArrivalTime = dogs.getLast().getArrivalTime();
            LocalDateTime oldestCatArrivalTime = cats.getLast().getArrivalTime();

            if (oldestDogArrivalTime.isBefore(oldestCatArrivalTime)) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public Dog dequeueDog() {
        return dogs.removeLast();
    }

    public Cat dequeueCat() {
        return cats.removeLast();
    }
}

abstract class Pet {
    private LocalDateTime arrivalTime;
    private String name;

    Pet(String name) {
        this.name = name;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    abstract public String toString();
}

class Cat extends Pet {
    Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat(name: " + getName() + ");";
    }
}

class Dog extends Pet {
    Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog(name: " + getName() + ");";
    }
}
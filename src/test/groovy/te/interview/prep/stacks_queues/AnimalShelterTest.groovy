package te.interview.prep.stacks_queues

import spock.lang.Specification

class AnimalShelterTest extends Specification {

    AnimalShelter animalShelter = []

    def "dequeueDog returns the dog that arrived first"() {
        given:
            Dog dog1 = new Dog("dog1")
            Dog dog2 = new Dog("dog2")
            Dog dog3 = new Dog("dog3")

        when:
            animalShelter.enqueue(dog1)
            animalShelter.enqueue(dog2)
            animalShelter.enqueue(dog3)

        then:
            animalShelter.dequeueDog() == dog1
            animalShelter.dequeueDog() == dog2
            animalShelter.dequeueDog() == dog3
    }

    def "dequeueCat returns the cat that arrived first"() {
        given:
            Cat cat1 = new Cat("cat1")
            Cat cat2 = new Cat("cat2")
            Cat cat3 = new Cat("cat3")

        when:
            animalShelter.enqueue(cat1)
            animalShelter.enqueue(cat2)
            animalShelter.enqueue(cat3)

        then:
            animalShelter.dequeueCat() == cat1
            animalShelter.dequeueCat() == cat2
            animalShelter.dequeueCat() == cat3
    }

    def "dequeueAny returns the Pet that arrived first (dog or cat)"() {
        given:
            Cat cat1 = new Cat("cat1")
            Dog dog1 = new Dog("dog1")
            Cat cat2 = new Cat("cat2")
            Dog dog2 = new Dog("dog2")
            Cat cat3 = new Cat("cat3")
            Dog dog3 = new Dog("dog3")

        when:
            animalShelter.enqueue(cat1)
            sleep(100)
            animalShelter.enqueue(dog1)
            sleep(100)
            animalShelter.enqueue(cat2)
            sleep(100)
            animalShelter.enqueue(dog2)
            sleep(100)
            animalShelter.enqueue(cat3)
            sleep(100)
            animalShelter.enqueue(dog3)

        then:
            animalShelter.dequeueAny() == cat1
            animalShelter.dequeueAny() == dog1
            animalShelter.dequeueAny() == cat2
            animalShelter.dequeueAny() == dog2
            animalShelter.dequeueAny() == cat3
            animalShelter.dequeueAny() == dog3
    }
}

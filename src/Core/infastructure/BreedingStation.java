package Core.infastructure;

import Core.Models.*;
import DB.SQLite;

import java.util.ArrayList;

public class BreedingStation {

    SQLite sqLite = new SQLite();
//    ArrayList<Animal> animals = new ArrayList<>();

    public BreedingStation() {
    }

    public void addAnimal(AnimalTypes type, String name, int age) {
        switch (type) {
            case CAT -> new Cat(name, age);
            case DOG -> new Dog(name, age);
            case HAMSTER -> new Hamster(name, age);
            case CAMEL -> new Camel(name, age);
            case HORSE -> new Horse(name, age);
            case DONKEY -> new Donkey(name, age);
        }
    }

    public void removeAnimal(AnimalTypes type, int id) {
        sqLite.removeAnimal(type, id);
    }

    public void getAnimal(AnimalTypes type, int id) {
        sqLite.printAnimal(type, id);
    }

    public int getAnimalId(AnimalTypes type, int id) {
        return sqLite.getAnimalId(type, id);
    }

    public int countAnimal(AnimalTypes type) {
        return sqLite.count(type);
    }
    public int getMaxId(AnimalTypes type) {
        return sqLite.getMaxId(type);
    }

    public void getAnimalCommands(AnimalTypes type, int id) {
        sqLite.getCommands(type, id);
    }

    public void learnNewCommand(AnimalTypes type, int id, String command) {
        sqLite.learnCommand(type, id, command);
    }
//
//    @Override
//    public boolean hasNext() {
//        return index < animals.size();
//    }
//
//    @Override
//    public Animal next() {
//        return animals.get(index++);
//    }
//
//    @Override
//    public void remove() {
//        animals.remove(index);
//    }
//    public boolean remove(int index) {
//        boolean flag = false;
//        if (animals.indexOf(index)) {
//            animals.remove(index);
//            flag = true;
//        }
//        return flag;
//    }
}

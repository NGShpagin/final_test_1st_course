package Core.infastructure;

import Core.Models.*;
import DB.SQLite;

public class BreedingStation {

    SQLite sqLite = new SQLite();

    public BreedingStation() {
        sqLite.createTable("commands");
        sqLite.createTable("dogs");
        sqLite.createTable("cats");
        sqLite.createTable("hamsters");
    }

    //create new animal
    public void addAnimal(AnimalTypes type, String name, int age) {

        switch (type) {
            case CAT -> {
                new Cat(name, age);
                sqLite.insertAnimal("cats", name, age);
            }
            case DOG -> {
                new Dog(name, age);
                sqLite.insertAnimal("dogs", name, age);
            }
            case HAMSTER -> {
                new Hamster(name, age);
                sqLite.insertAnimal("hamsters", name, age);
            }
            case CAMEL -> {
                new Camel(name, age);
                sqLite.insertAnimal("camels", name, age);
            }
            case HORSE -> {
                new Horse(name, age);
                sqLite.insertAnimal("horses", name, age);
            }
            case DONKEY -> {
                new Donkey(name, age);
                sqLite.insertAnimal("donkeys", name, age);
            }
        }
    }

    public void removeAnimal(AnimalTypes type, int id) {
        switch (type) {
            case CAT -> sqLite.removeAnimal("cats", id);
            case DOG -> sqLite.removeAnimal("dogs", id);
            case HAMSTER -> sqLite.removeAnimal("hamsters", id);
            case CAMEL -> sqLite.removeAnimal("camels", id);
            case HORSE -> sqLite.removeAnimal("horses", id);
            case DONKEY -> sqLite.removeAnimal("donkeys", id);
        }
    }

    public void getAnimal(String table, int id) {
        sqLite.printAnimal(table, id);
    }

    public int countAnimal(String table) {
        return sqLite.count(table);
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

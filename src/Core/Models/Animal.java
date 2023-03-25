package Core.Models;

import DB.SQLite;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Animal {
    AnimalTypes type;
    private int id;
    private String name;
    private int age;
    SQLite sqLite = new SQLite();
    private ArrayList<String> commands;

    public Animal(String name, int age, AnimalTypes type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getId(int id) {
        return sqLite.getAnimalId(type, id);
    }

    public void getCommands() {
        sqLite.getCommands(type, id);
    }

    public void setCommands(String command) {
        sqLite.learnCommand(type, id, command);
    }

//    public void learnNewCommand(String command) {
//        if (commands.contains(command)) System.out.println("Such command is already learnt!");
//        else this.commands.add(command);
//    }
//    public ArrayList<String> getCommands(AnimalTypes animalType) {
//        sqLite.getCommands(animalType, getId());
//    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBirthday: %d\n", name, age);
    }
}

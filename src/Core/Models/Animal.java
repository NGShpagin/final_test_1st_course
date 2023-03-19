package Core.Models;

import java.util.ArrayList;

public abstract class Animal {
    private int id;
    private String name;
    private int age;
    private ArrayList<String> commands;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setBirthday(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void learnNewCommand(String command) {
        if (commands.contains(command)) System.out.println("Such command is already learnt!");
        else this.commands.add(command);
    }
    public ArrayList<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBirthday: %d\n", name, age);
    }


}

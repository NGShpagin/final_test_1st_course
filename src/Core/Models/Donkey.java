package Core.Models;

import Core.Models.PackAnimal;
import DB.SQLite;

import java.util.Date;

public class Donkey extends Animal {
    SQLite sqLite = new SQLite();
    public Donkey(String name, int age) {
        super(name, age, AnimalTypes.DONKEY);
        sqLite.insertAnimal(type, name, age);
    }
}

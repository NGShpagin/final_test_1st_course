package Core.Models;

import Core.Models.DomesticAnimal;
import DB.SQLite;

import java.util.Date;

public class Hamster extends Animal {
    SQLite sqLite = new SQLite();
    public Hamster(String name, int age) {
        super(name, age, AnimalTypes.HAMSTER);
        sqLite.insertAnimal(type, name, age);
    }
}

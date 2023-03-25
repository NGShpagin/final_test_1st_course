package Core.Models;

import Core.Models.PackAnimal;
import DB.SQLite;

import java.util.Date;

public class Horse extends Animal {
    SQLite sqLite = new SQLite();
    public Horse(String name, int age) {
        super(name, age, AnimalTypes.HORSE);
        sqLite.insertAnimal(type, name, age);
    }
}

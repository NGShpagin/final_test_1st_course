package Core.Models;

import Core.Models.PackAnimal;
import DB.SQLite;

import java.util.Date;

public class Camel extends Animal {
    SQLite sqLite = new SQLite();
    public Camel(String name, int age) {
        super(name, age, AnimalTypes.CAMEL);
        sqLite.insertAnimal(type, name, age);
    }
}

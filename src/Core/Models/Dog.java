package Core.Models;

import Core.Models.DomesticAnimal;
import DB.SQLite;

import java.util.Date;

public class Dog extends Animal {
    SQLite sqLite = new SQLite();
    public Dog(String name, int age) {
        super(name, age, AnimalTypes.DOG);
        sqLite.insertAnimal(type, name, age);
    }
}

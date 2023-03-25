package Core.Models;

import DB.SQLite;

public class Cat extends Animal {

    SQLite sqLite = new SQLite();
    public Cat(String name, int age) {
        super(name, age, AnimalTypes.CAT);
        sqLite.insertAnimal(type, name, age);
    }

    @Override
    public int getId(int id) {
        return super.getId(id);
    }
}

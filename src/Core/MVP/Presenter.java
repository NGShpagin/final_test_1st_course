package Core.MVP;

import Core.Models.Animal;
import Core.Models.AnimalTypes;

public class Presenter {
    private final Model model;
    private final View view;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
    }

    public void printAnimal(String table) {
        model.currentAnimal(table);
    }

    public void setCurrentIndex(int index) {
        model.setCurrentIndex(index);
    }

    public void addAnimal(AnimalTypes type) {
        model.currentStation().addAnimal(type, view.getName(), view.getAge());
    }

    public void removeAnimal(AnimalTypes type) {
        model.currentStation().removeAnimal(type, model.getCurrentIndex());
    }

    public void next(String table) {
        if (model.currentStation().countAnimal(table) > 0) {
            if (model.getCurrentIndex() + 1 <= model.currentStation().countAnimal(table)) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                printAnimal(table);
            } else {
                printAnimal(table);
            }
        }
    }

    public void prev(String table) {
        if (model.currentStation().countAnimal(table) > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                printAnimal(table);
            } else {
                printAnimal(table);
            }
        }
    }

}

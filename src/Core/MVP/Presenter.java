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

    public void printAnimal(AnimalTypes type) {
        model.currentAnimal(type);
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

    public void getCommands(AnimalTypes type) {
        model.getCommands(type);
    }

    public void learnNewCommand(AnimalTypes type) {
        model.learnNewCommand(type, view.getCommand());
    }

    public void next(AnimalTypes type) {
        if (model.currentStation().countAnimal(type) > 0) {
            if (model.getCurrentIndex() + 1 <= model.currentStation().getMaxId(type)) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                while (model.getCurrentIndex() != model.getCurrentAnimalId(type))
                    model.setCurrentIndex(model.getCurrentIndex() + 1);
                printAnimal(type);
            } else {
                printAnimal(type);
            }
        }
    }

    public void prev(AnimalTypes type) {
        if (model.currentStation().countAnimal(type) > 0 && model.getCurrentIndex() - 1 > 0) {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            while (model.getCurrentIndex() > -1 && model.getCurrentIndex() != model.getCurrentAnimalId(type))
                model.setCurrentIndex(model.getCurrentIndex() - 1);
            printAnimal(type);
        } else {
            printAnimal(type);
        }
    }

}

package Core.MVP;

import Core.Models.Animal;
import Core.Models.AnimalTypes;
import Core.infastructure.BreedingStation;

public class Model {
    BreedingStation currentBreedingStation;
    private int currentIndex;


    public Model() {
        currentBreedingStation = new BreedingStation();
        currentIndex = 1;
    }

    public void currentAnimal(AnimalTypes type) {
        currentStation().getAnimal(type, currentIndex);
    }

    public int getCurrentAnimalId(AnimalTypes type) {
        return currentStation().getAnimalId(type, currentIndex);
    }

    public BreedingStation currentStation() {
        return this.currentBreedingStation;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    public void getCommands(AnimalTypes type) {
        currentStation().getAnimalCommands(type, currentIndex);
    }

    public void learnNewCommand(AnimalTypes type, String command) {
        currentStation().learnNewCommand(type, currentIndex, command);
    }
}

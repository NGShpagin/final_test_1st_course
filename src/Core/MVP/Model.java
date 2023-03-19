package Core.MVP;

import Core.Models.Animal;
import Core.infastructure.BreedingStation;

public class Model {
    BreedingStation currentBreedingStation;
    private int currentIndex;


    public Model() {
        currentBreedingStation = new BreedingStation();
        currentIndex = 1;
    }

    public void currentAnimal(String table) {
        currentStation().getAnimal(table, currentIndex);
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
}

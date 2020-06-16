package shelter;

public class VirtualPet {
    private String petName;
    private String description;
    private int hanger;
    private int thirst;
    private int potty;
    private int boredom;
    private int tiredness;

    public String toString() {
        return this.petName + ": " + this.description;
    }

    public VirtualPet(String petName,
                      String petDescription,
                      int boredom,
                      int hanger,
                      int thirst,
                      int potty,
                      int bored,
                      int tiredness) {
        this.petName = petName;
        this.description = petDescription;
        this.hanger = 6;
        this.thirst = 6;
        this.potty = 6;
        this.boredom = 6;
        this.tiredness = 6;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getPetDescription() {
        return this.description;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public int getHanger() {
        return this.hanger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public int getPotty() {
        return this.potty;
    }

    public int getTiredness() {
        return this.tiredness;
    }

    public void playGame() {
        if (boredom < 5) {
            boredom -= 5;
        } else boredom = 0;
    }

    public void feedPet() {
        if (hanger > 5) {
            hanger -= 5;
        } else hanger = 0;
    }

    public void waterToPet() {
        if (thirst > 5) {
            thirst -= 5;
        } else thirst = 0;
    }

    public void takePetOut() {
        if (potty > 5) {
            potty -= 5;
        } else potty = 0;
    }

    public void sleepPets() {
        if (tiredness > 5) {
            tiredness -= 5;
        } else tiredness = 0;
    }

    public void tick() {
        if (hanger < 10) {
            hanger += 1;
        }
        if (thirst < 10) {
            thirst += 1;
        }
        if (boredom < 10) {
            boredom += 1;
        }
        if (potty < 10) {
            potty += 1;
        }
        if (tiredness < 10) {
            tiredness += 1;
        }
    }
}

package shelter;

import java.util.*;

public class VirtualPetShelter {
    Map<String, VirtualPet> pets = new HashMap<>();

    public void addPet(VirtualPet pet) {
        pets.put(pet.getPetName(), pet);
    }

    public VirtualPet findByName(String keyPetName) {
        return pets.get(keyPetName);
    }

    public Collection<VirtualPet> getListOfAllPets() {
        return pets.values();
    }

    public void removePet(VirtualPet pet) {
        pets.remove(pet.getPetName(), pet);
    }

    public void playWithPet(String keyPetName) {
        VirtualPet enteredPet = findByName(keyPetName);
        enteredPet.playGame();
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.feedPet();
        }
    }

    public void waterToAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.waterToPet();
        }
    }

    public void tickAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.tick();
        }
    }

    public static boolean gameOn() {
        return true;
    }

    public void takeAllPetsOut() {
        for (VirtualPet pet : pets.values()) {
            pet.takePetOut();
        }
    }

    public void sleepAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.sleepPets();
        }
    }

    public void displayAllPetsAndStats() {
        for (VirtualPet pet : pets.values()) {
            System.out.print(pet.getPetName() + ":       "
                    + pet.getBoredom() + "        "
                    + pet.getHanger() + "        "
                    + pet.getThirst() + "       "
                    + pet.getPotty() + "           "
                    + pet.getTiredness());
            System.out.println();
        }
    }

    public void displayPetsToPlayWith() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.getPetName() + ": " + pet.getPetDescription());
        }
    }

    public void introDisplay(){
        System.out.println("        __         /    ");
        System.out.println("      (  _ _ _ '_    _  ");
        System.out.println("     __)(-(/(//(-  _)   ");
        System.out.println("          _/_/          ");
        System.out.println();
        System.out.println("       []___");
        System.out.println("      /    /\\");
        System.out.println("     /____/__\\");
        System.out.println("     |[][]||||");
        System.out.println();
        System.out.println("Thank you for volunteering at Sad Seggie's Virtual Pet Shelter!");
        System.out.println();
    }

    public void displayStatusOfPetsAndAttributes(){
        System.out.println("This is the status of your pets:");
        System.out.println();
        System.out.println("Name |Boredom  |Hanger  |Thirst  |Potty  |Tiredness  |");
    }

    public void displayUserOptions(){
        System.out.println("What would you like to do next?");
        System.out.println("1. Feed the pets");
        System.out.println("2. Give water to pets");
        System.out.println("3. Take pets outside");
        System.out.println("4. Play with a pet");
        System.out.println("5. Put pets to sleep");
        System.out.println("6. Adopt a pet");
        System.out.println("7. Admit a pet");
        System.out.println("8. Quit");
    }

    public void gameOver(){
        System.out.println("   _____          __  __ ______ ______      ________ _____ ");
        System.out.println("  / ____|   /\\   |  \\/  |  ____/ __ \\ \\    / /  ____|  __ \\");
        System.out.println(" | |  __   /  \\  | \\  / | |__ | |  | \\ \\  / /| |__  | |__) |");
        System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|| |  | |\\ \\/ / |  __| |  _  / ");
        System.out.println(" | |__| |/ ____ \\| |  | | |___| |__| | \\  /  | |____| | \\ \\ ");
        System.out.println("  \\_____/_/    \\_\\_|  |_|______\\____/   \\/   |______|_|  \\_\\");
        System.out.println("");
        System.out.println("Fine! Quit! Just like that. It's over.");
        System.exit(0);
    }
}

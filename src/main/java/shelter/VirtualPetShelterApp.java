package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPet Argo = new VirtualPet("Argo", "SuperCool", 1, 1, 1, 1, 1, 1);
        VirtualPet Spot = new VirtualPet("Spot", "SuperLame", 1, 1, 1, 1, 1, 1);
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.addPet(Argo);
        myShelter.addPet(Spot);
        myShelter.introDisplay();
        while (VirtualPetShelter.gameOn()) {
            myShelter.displayStatusOfPetsAndAttributes();
            myShelter.displayAllPetsAndStats();
            System.out.println("Don't let these stats get to 10!");
            System.out.println();
            myShelter.displayUserOptions();
            int userChoice = input.nextInt();
            if ((userChoice <= 0 || userChoice > 8)) {
                System.out.println("You entered: " + userChoice + ", which is not a valid option");
                myShelter.tickAllPets();
            }
            if (userChoice == 1) {
                System.out.println("You entered: " + userChoice + ". Feed the pets.");
                System.out.println("They are not themselves when they are hungry, but it seems like they are always hungry!");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.feedAllPets();
            }
            if (userChoice == 2) {
                System.out.println("You chose: " + userChoice + ". Give water to all of the pets.");
                System.out.println("They love the virtual water, and they all seem to drinks in 3's.");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.waterToAllPets();
            }
            if (userChoice == 3) {
                System.out.println("You chose: " + userChoice + ". Take pets outside. ");
                System.out.println("Yay, they all went potty!.");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.takeAllPetsOut();
            }
            if (userChoice == 4) {
                System.out.println("You chose: " + userChoice + " Play with a pet");
                System.out.println();
                System.out.println("Ok, which pet would you like to play with?");
                myShelter.displayPetsToPlayWith();
                String petUserEntered = input.next();
                while (!myShelter.pets.containsKey(petUserEntered)) {
                    System.out.println("You have entered an invalid name");
                    System.out.println("Please enter a valid name:");
                    petUserEntered = input.next();
                    myShelter.findByName(petUserEntered);
                }
                myShelter.playWithPet(petUserEntered);
                myShelter.tickAllPets();
            }
            if (userChoice == 5) {
                System.out.println("You chose: " + userChoice + " Put pets to sleep, because they are tired");
                System.out.println();
                System.out.println("Shh, they are all sleeping, until you wake them up.");
                System.out.println();
                myShelter.tickAllPets();
                myShelter.sleepAllPets();
            }
            if (userChoice == 6) {
                System.out.println("Which pet would you like to adopt?");
                System.out.println(myShelter.getListOfAllPets());
                String petEnteredToAdopt = input.next();
                while (!myShelter.pets.containsKey(petEnteredToAdopt)) {
                    System.out.println("You have entered an invalid name");
                    System.out.println("Please enter a valid name:");
                    petEnteredToAdopt = input.next();
                    myShelter.findByName(petEnteredToAdopt);
                    System.out.println("Oh no! It looks like we do not have that pet here! Please enter a valid pet name:");
                }
                if (myShelter.pets.containsKey(petEnteredToAdopt)) {
                    myShelter.pets.remove(petEnteredToAdopt);
                }
            }
            if (userChoice == 7) {
                System.out.println("What is your pets name that you are admitting?");
                String inputNewPet = input.next();
                //will skip description if nextLine
                //will not prompt for description if next
                while (myShelter.pets.containsKey(inputNewPet)) {
                    System.out.println("Oh no! We already have that pet with that name. Does he have another name it goes by?");
                    inputNewPet =input.next();
                }
                System.out.println("Please describe the pet that you are admitting");
                String inputNewDescription = input.next();
                //will skip description if nextLine
                //will break if next
                VirtualPet inputPet = new VirtualPet(inputNewPet, inputNewDescription, 1, 1, 1, 1, 1, 1);
                myShelter.addPet(inputPet);
            }
            if (userChoice == 8) {
                System.out.println("You chose: " + userChoice + ". Quit");
                myShelter.gameOver();
            }
        }
    }
}
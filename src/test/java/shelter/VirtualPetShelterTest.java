package shelter;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class VirtualPetShelterTest {
    VirtualPetShelter underTest;
    VirtualPet pet1;
    VirtualPet pet2;

    @Before
    public void setUp() {
        underTest = new VirtualPetShelter();
        pet1 = new VirtualPet("Argo", "SuperCool", 1, 1, 1, 1, 1, 1);
        pet2 = new VirtualPet("Spot", "SuperLame", 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void shouldAddVirtualPet() {
        underTest.addPet(pet1);
        VirtualPet enteredPet = underTest.findByName("Argo");
        Assertions.assertThat(enteredPet).isEqualTo(pet1);
    }
    @Test
    public void shouldAddTwoVirtualPets() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        VirtualPet enteredPet = underTest.findByName("Spot");
        Collection<VirtualPet> allPets = underTest.getListOfAllPets();
        Assertions.assertThat(allPets).contains(pet2, pet1);
    }
    @Test
    public void shouldRemovePet() {
        underTest.addPet(pet1);
        underTest.removePet(pet1);
        VirtualPet enteredPet = underTest.findByName(pet1.getPetName());
        Assertions.assertThat(enteredPet).isNotEqualTo(pet1);
    }
    @Test
    public void shouldSubtractBoredomFromSelectedPetWithPlayWithPet() {
        underTest.addPet(pet1);
        VirtualPet enteredPet = underTest.findByName(pet1.getPetName());
        int boredomBeforePlaying = pet1.getBoredom();
        underTest.playWithPet(pet1.getPetName());
        int boredomAfterPlaying = pet1.getBoredom();
        Assertions.assertThat(boredomBeforePlaying).isGreaterThan(boredomAfterPlaying);
    }
    @Test
    public void shouldSubtractHangerFromAllPetsWithFeedPets() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        int hangerBeforeFeeding1 = pet1.getHanger();
        int hangerBeforeFeeding2 = pet2.getHanger();
        underTest.feedAllPets();
        int hangerAfterFeeding1 = pet1.getHanger();
        int hangerAfterFeeding2 = pet2.getHanger();
        Assertions.assertThat(hangerBeforeFeeding1).isGreaterThan(hangerAfterFeeding1);
        Assertions.assertThat(hangerBeforeFeeding2).isGreaterThan(hangerAfterFeeding2);
    }
    @Test
    public void shouldSubtractThirstFromAllPetsWaterToAllPets() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        int thirstBeforeWater1 = pet1.getThirst();
        int thirstBeforeWater2 = pet2.getThirst();
        underTest.waterToAllPets();
        int thirstAfterWater1 = pet1.getThirst();
        int thirstAfterWater2 = pet2.getThirst();
        Assertions.assertThat(thirstBeforeWater1).isGreaterThan(thirstAfterWater1);
        Assertions.assertThat(thirstBeforeWater2).isGreaterThan(thirstAfterWater2);
    }
    @Test
    public void shouldSubtractPottyFromAllPetsWithTakeAllPetsOut() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        int pottyBeforeTakingOut1 = pet1.getPotty();
        int pottyBeforeTakingOut2 = pet2.getPotty();
        underTest.takeAllPetsOut();
        int pottyAfterTakingOut1 = pet1.getPotty();
        int pottyAfterTakingOut2 = pet2.getPotty();
        Assertions.assertThat(pottyBeforeTakingOut1).isGreaterThan(pottyAfterTakingOut1);
        Assertions.assertThat(pottyBeforeTakingOut2).isGreaterThan(pottyAfterTakingOut2);
    }
    @Test
    public void shouldSubtractTirednessFromAllPetsWithSleepAllPets() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        int tirednessBeforeSleeping1 = pet1.getTiredness();
        int tirednessBeforeSleeping2 = pet2.getTiredness();
        underTest.sleepAllPets();
        int tirednessAfterSleeping1 = pet1.getTiredness();
        int tirednessAfterSleeping2 = pet2.getTiredness();
        Assertions.assertThat(tirednessBeforeSleeping1).isGreaterThan(tirednessAfterSleeping1);
        Assertions.assertThat(tirednessBeforeSleeping2).isGreaterThan(tirednessAfterSleeping2);
    }
    @Test
    public void shouldAddTickToAllStatsWithTickAllPets() {
        underTest.addPet(pet1);
        underTest.addPet(pet2);
        underTest.tickAllPets();
        Assertions.assertThat(pet1.getBoredom()).isEqualTo(7);
        Assertions.assertThat(pet2.getBoredom()).isEqualTo(7);
        Assertions.assertThat(pet1.getHanger()).isEqualTo(7);
        Assertions.assertThat(pet2.getHanger()).isEqualTo(7);
        Assertions.assertThat(pet1.getThirst()).isEqualTo(7);
        Assertions.assertThat(pet2.getThirst()).isEqualTo(7);
        Assertions.assertThat(pet1.getTiredness()).isEqualTo(7);
        Assertions.assertThat(pet2.getTiredness()).isEqualTo(7);
    }
}
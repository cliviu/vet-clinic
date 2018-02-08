package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;
import serenitylabs.tutorials.vetclinic.model.*;

public class CheckIn implements Performable {

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel){

        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checks #pet into #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkIn(pet);
    }

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }


    public static class CheckInBuilder {

        private Pet pet;

        public CheckInBuilder(Pet pet) {

            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            //return new CheckIn(pet, petHotel);
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, petHotel);
        }
    }
}

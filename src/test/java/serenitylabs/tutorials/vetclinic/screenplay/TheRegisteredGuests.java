package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.annotations.*;
import serenitylabs.tutorials.vetclinic.model.*;

import java.util.*;

@Subject("the pets in the hotel")
public class TheRegisteredGuests implements Question<List<Pet>>
{
    private PetHotel petHotel;

    public TheRegisteredGuests(PetHotel petHotel) {

        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getPets();
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheRegisteredGuests(petHotel);
    }
}

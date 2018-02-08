package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.*;
import net.serenitybdd.screenplay.*;
import org.junit.*;
import org.junit.runner.*;
import serenitylabs.tutorials.vetclinic.model.*;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel(){

        //GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("Best Pet Hotel");


        //WHEN
        petra.attemptsTo(CheckIn.aPet(ginger).into(petHotel));
        //??

        //THEN
        //assertThat(petHotel.getPets(),hasItem(ginger));

        petra.should(seeThat(TheRegisteredGuests.in(petHotel),hasItem(ginger)));


    }

}

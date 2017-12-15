package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {

    @Test
    public void it_should_have_a_name() {

        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = Dog.called("Fido")
                    .ofBreed("Poodle")
                    .ofColour("black")
                    .withFavouriteFoodOf("pizza")
                    .bornOn(birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDateOfBirth());
        Assert.assertEquals("pizza", fido.getFavouriteFood());
        Assert.assertEquals("black", fido.getColour());
    }

}

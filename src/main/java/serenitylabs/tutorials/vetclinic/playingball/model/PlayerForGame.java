package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Cricket;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Football;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Handball;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Hockey;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Tennis;

public class PlayerForGame {

    public static Player called(Game game) {
        if (game == Football) {
            return new PlayFootball();
        } else if (game == Tennis) {
            return new PlayTennis();
        } else if (game == Cricket) {
            return new PlayCricket();
        } else if (game == Handball) {
            return new PlayHandball();
        } else if (game == Hockey) {
            return new PlayHockey();
        } else {
            return null;
        }
    }


}

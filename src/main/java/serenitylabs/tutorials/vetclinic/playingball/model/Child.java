package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class Child {

    public void goPlay(Game game) {
        getPlayerForGame(game).play();
    }

    private Player getPlayerForGame(Game game)
    {
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

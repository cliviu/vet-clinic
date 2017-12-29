package serenitylabs.tutorials.vetclinic.playingball.model;

public class Child {

    public void goPlay(Game game) {
        PlayerForGame.called(game).play();
    }
}

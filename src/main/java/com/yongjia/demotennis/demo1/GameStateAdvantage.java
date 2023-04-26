package com.yongjia.demotennis.demo1;

public class GameStateAdvantage extends GameState {
    public GameStateAdvantage(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return tennisGame.getPlayer1Point() > tennisGame.getPlayer2Point()?
                String.format("%s Advantage", tennisGame.getPlayer1()):
                String.format("%s Advantage", tennisGame.getPlayer2());
    }
}

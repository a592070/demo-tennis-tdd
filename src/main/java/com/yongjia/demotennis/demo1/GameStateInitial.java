package com.yongjia.demotennis.demo1;

public class GameStateInitial extends GameState{
    public GameStateInitial(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return tennisGame.scoreMap.get(tennisGame.getPlayer1Point()) + ":" + tennisGame.scoreMap.get(tennisGame.getPlayer2Point());
    }
}

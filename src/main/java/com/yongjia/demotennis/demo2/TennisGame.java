package com.yongjia.demotennis.demo2;


import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

public class TennisGame {
    @Getter
    private String player1;

    @Getter
    private int player1Point = 0;

    @Getter
    private String player2;

    @Getter
    private int player2Point = 0;

    public Map<Integer, String> scoreMap = ImmutableMap.of(
            0, "love",
            1, "fifteen",
            2, "thirty",
            3, "forty"
    );

    GameState gameState;

    private final GameState INITIAL = new GameStateInitial(this);
    private final GameState DEUCE = new GameStateDeuce(this);
    private final GameState ADVANTAGE = new GameStateAdvantage(this);
    private final GameState GAME_OVER = new GameStateGameOver(this);

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameState = INITIAL;
    }

    public void wonPoint(String player) {
        if(Objects.equals(this.player1, player)){
            this.player1Point++;
        }else if(Objects.equals(this.player2, player)){
            this.player2Point++;
        }else{
            throw new RuntimeException(String.format("Unknown player: %s", player));
        }
        nextState();
    }

    private void nextState() {
        if(isDeuce()){
            gameState = DEUCE;
        }else if(isGameOver()){
            gameState = GAME_OVER;
        }else if(isAdvantage()){
            gameState = ADVANTAGE;
        }
    }

    private boolean isAdvantage() {
        return (this.player1Point >= 4 || this.player2Point >= 4) && Math.abs(this.player1Point - this.player2Point) == 1;
    }

    private boolean isGameOver() {
        return (this.player1Point >= 4 || this.player2Point >= 4) && Math.abs(this.player1Point - this.player2Point) >= 2;
    }

    private boolean isDeuce() {
        return this.player1Point == this.player2Point && this.player1Point >= 3;
    }


    public String getDisplayScore() {
        return gameState.getDisplayScore();
    }
}

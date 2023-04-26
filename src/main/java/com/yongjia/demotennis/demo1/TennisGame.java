package com.yongjia.demotennis.demo1;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

public class TennisGame {

    @Getter
    private String player1;
    @Getter
    private int player1Point;

    @Getter
    private String player2;
    @Getter
    private int player2Point;

    Map<Integer, String> scoreMap = ImmutableMap.of(
            0, "love",
            1, "fifteen",
            2, "thirty",
            3, "forty"
    );

    private GameState gameState;
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
            this.gameState = DEUCE;
        }
        if(isAdvantage()) {
            this.gameState = ADVANTAGE;
        }
        if(isGameOver()){
            this.gameState = GAME_OVER;
        }
    }

    public String getDisplayScore() {
        return this.gameState.getDisplayScore();
    }

    private boolean isGameOver() {
        return (this.player1Point >= 4 || this.player2Point >= 4) && Math.abs(this.player1Point - this.player2Point) >= 2;
    }

    private boolean isAdvantage() {
        return (this.player1Point >= 4 || this.player2Point >= 4) && Math.abs(this.player1Point - this.player2Point) == 1;
    }

    private boolean isDeuce() {
        return this.player1Point == this.player2Point && this.player1Point >= 3;
    }


    public String getScore() {
        return String.format("%d:%d", this.player1Point, this.player2Point);
    }
}

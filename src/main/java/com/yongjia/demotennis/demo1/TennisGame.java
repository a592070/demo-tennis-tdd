package com.yongjia.demotennis.demo1;

import lombok.Getter;

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

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if(Objects.equals(this.player1, player)){
            this.player1Point++;
        }else if(Objects.equals(this.player2, player)){
            this.player2Point++;
        }else{
            throw new RuntimeException(String.format("Unknown player: %s", player));
        }
    }

    public String getDisplayScore() {
        return null;
    }

    public String getScore() {
        return String.format("%d:%d", this.player1Point, this.player2Point);
    }
}

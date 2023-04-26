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
        }
    }
}

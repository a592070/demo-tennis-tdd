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
        if(isDeuce()){
            return "Deuce";
        }
        if(isAdvantage()) {
            return this.player1Point > this.player2Point ?
                    String.format("%s Advantage", player1):
                    String.format("%s Advantage", player2);
        }
        return String.format("%s:%s", this.scoreMap.get(this.player1Point), this.scoreMap.get(this.player2Point));
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

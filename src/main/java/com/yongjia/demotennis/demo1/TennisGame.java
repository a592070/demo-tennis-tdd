package com.yongjia.demotennis.demo1;


import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
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

    private Map<Integer, String> scoreMap = ImmutableMap.of(
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
        if(this.player1Point < 4 && this.player2Point < 4 && (this.player1Point + this.player2Point) != 6){
            return scoreMap.get(this.player1Point) + ":" + scoreMap.get(this.player2Point);
        }
        if(this.player1Point == this.player2Point) return "deuce";
        if(Math.abs(this.player1Point - this.player2Point) == 1){
            return this.player1Point>this.player2Point?
                    String.format("%s advantage", player1):
                    String.format("%s advantage", player2);
        }
        return this.player1Point>this.player2Point?
                String.format("%s won", player1):
                String.format("%s won", player2);
    }
}

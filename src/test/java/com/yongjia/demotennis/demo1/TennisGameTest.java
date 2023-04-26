package com.yongjia.demotennis.demo1;

import com.yongjia.demotennis.demo1.TennisGame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TennisGameTest {

    TennisGame tennisGame;

    String player1 = "player1";
    String player2 = "player2";

    @Test
    void player1_getPoint() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        assertEquals(tennisGame.getPlayer1Point(), 1);
    }

    @Test
    void player2_getPoint() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player2);
        assertEquals(tennisGame.getPlayer2Point(), 1);
    }

    @Test
    void player_unknown() {
        TennisGame tennisGame = new TennisGame(player1, player2);
        assertThrows(RuntimeException.class, () -> tennisGame.wonPoint("player unknown"));
    }

    @Test
    void player1_vs_player2_is_1_vs_0() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        assertEquals(tennisGame.getScore(), "1:0");
        assertEquals(tennisGame.getDisplayScore(), "fifteen:love");
    }
}
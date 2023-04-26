package com.yongjia.demotennis.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TennisGameTest {

    TennisGame tennisGame;
    String player1 = "player1";
    String player2 = "player2";

    @Test
    void player1_getPoint() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        assert tennisGame.getPlayer1Point() == 1;
    }
    @Test
    void player2_getPoint() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player2);
        assert tennisGame.getPlayer2Point() == 1;
    }

    @Test
    void player1_vs_player2_equal_1_vs_0() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        assertEquals(tennisGame.getDisplayScore(), "fifteen:love");
    }

    @Test
    void player1_vs_player2_equal_1_vs_1() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        assertEquals(tennisGame.getDisplayScore(), "fifteen:fifteen");
    }

    @Test
    void player1_vs_player2_equal_2_vs_1() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        assertEquals(tennisGame.getDisplayScore(), "thirty:fifteen");
    }

    @Test
    void player1_vs_player2_equal_3_vs_1() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player1);
        assertEquals(tennisGame.getDisplayScore(), "forty:fifteen");
    }

    @Test
    void player1_vs_player2_equal_4_vs_1() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player1);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s won", player1));
    }

    @Test
    void player1_vs_player2_equal_2_vs_4() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player2);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s won", player2));
    }

    @Test
    void player1_vs_player2_equal_3_vs_3() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);

        assertEquals(tennisGame.getDisplayScore(), "deuce");
    }

    @Test
    void player1_vs_player2_equal_4_vs_3() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s advantage", player1));
    }

    @Test
    void player1_vs_player2_equal_5_vs_4() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s advantage", player1));
    }

    @Test
    void player1_vs_player2_equal_5_vs_5() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);

        assertEquals(tennisGame.getDisplayScore(), "deuce");
    }

    @Test
    void player1_vs_player2_equal_7_vs_5() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player1);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s won", player1));
    }

    @Test
    void player1_vs_player2_equal_5_vs_7() {
        TennisGame tennisGame = new TennisGame(player1, player2);

        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player1);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player2);
        tennisGame.wonPoint(player2);

        assertEquals(tennisGame.getDisplayScore(), String.format("%s won", player2));
    }
}
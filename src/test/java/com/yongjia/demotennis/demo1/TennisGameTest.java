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
}
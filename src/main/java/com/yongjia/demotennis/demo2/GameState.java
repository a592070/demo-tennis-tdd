package com.yongjia.demotennis.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Game State of Tennis
 * Rules:
 *  initial: all player score are < 3
 *  deuce: after initial, all player has same score, and >= 3
 *  advantage: after deuce state, if a plyer gain one point
 *  game over:
 *      1. after deuce state, if a plyer gain more than one point
 *      2. or after initial, a player gain 4 point
 */
@AllArgsConstructor
public abstract class GameState {
    TennisGame tennisGame;

    public abstract String getDisplayScore();
}

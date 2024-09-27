#ifndef GAME_H
#define GAME_H

#include "Board.h"
#include "Player.h"

class Game {
private:
    Board board;
    Player playerX;
    Player playerO;
    Player* currentPlayer;

public:
    Game();
    void start();
    void switchTurn();
    bool isGameOver();
};

#endif

#ifndef PLAYER_H
#define PLAYER_H

#include "Board.h"

class Player {
private:
    char symbol;

public:
    Player(char symbol);
    char getSymbol();
    void makeMove(Board& board);
};

#endif

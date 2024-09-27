#include "Game.h"
#include <iostream>

Game::Game() : playerX('X'), playerO('O') {
    currentPlayer = &playerX;
}

void Game::start() {
    while (!isGameOver()) {
        board.print();
        currentPlayer->makeMove(board);
        if (isGameOver()) {
            board.print();
            std::cout << "Player " << currentPlayer->getSymbol() << " wins!" << std::endl;
            return;
        }
        switchTurn();
    }
}

void Game::switchTurn() {
    currentPlayer = (currentPlayer == &playerX) ? &playerO : &playerX;
}

bool Game::isGameOver() {
    return board.isFull() || board.checkWin();
}

#include "Player.h"
#include <iostream>

Player::Player(char sym) : symbol(sym) {}

char Player::getSymbol() {
    return symbol;
}

void Player::makeMove(Board& board) {
    int row, col;
    do {
        std::cout << "Player " << symbol << ", enter your move (row and column): ";
        std::cin >> row >> col;
    } while (!board.placeMarker(row - 1, col - 1, symbol));
}

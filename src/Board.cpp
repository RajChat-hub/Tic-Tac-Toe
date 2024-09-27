#include "Board.h"
#include <iostream>

Board::Board() {
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            grid[i][j] = ' ';
}

bool Board::placeMarker(int row, int col, char marker) {
    if (grid[row][col] == ' ') {
        grid[row][col] = marker;
        return true;
    }
    return false;
}

bool Board::checkWin() {
    // Check rows, columns, and diagonals for a win
    for (int i = 0; i < 3; i++) {
        if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ')
            return true;
        if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ')
            return true;
    }
    if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ')
        return true;
    if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ')
        return true;
    return false;
}

bool Board::isFull() {
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j)
            if (grid[i][j] == ' ')
                return false;
    return true;
}

void Board::print() {
    std::cout << "-------------\n";
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            std::cout << "| " << grid[i][j] << " ";
        }
        std::cout << "|\n-------------\n";
    }
}

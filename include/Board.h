#ifndef BOARD_H
#define BOARD_H

class Board {
private:
    char grid[3][3];

public:
    Board();
    bool placeMarker(int row, int col, char marker);
    bool checkWin();
    bool isFull();
    void print();
};

#endif

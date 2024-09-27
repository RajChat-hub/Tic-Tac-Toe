CC = g++
CFLAGS = -std=c++11 -Wall -Iinclude  # Add -Iinclude to tell the compiler to look in the include/ directory
SRC = src/Game.cpp src/Board.cpp src/Player.cpp src/main.cpp  # Include main.cpp
OBJ = $(SRC:.cpp=.o)
EXEC = tic_tac_toe

all: $(OBJ)
	$(CC) $(OBJ) -o $(EXEC)

%.o: %.cpp
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(EXEC)

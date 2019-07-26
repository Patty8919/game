package TicTacToe;

public class Computer {
    public int getMove(Scene scene) {
        Scene boardCopy = scene.copy();


        if (boardCopy.spotAvailable(4)) {
            return 4;

        } else if (boardCopy.getBoard()[4] == scene.getPlayer() &&
                boardCopy.spotAvailable(2)) {
            return 2;
        }

        int computerIndex = findWinPosition(boardCopy, scene.getComputer());
        if (computerIndex != -1) {
            return computerIndex;
        }

        int playerIndex = findWinPosition(boardCopy, scene.getPlayer());
        if (playerIndex != -1) {
            return playerIndex;
        }

        computerIndex = findFork(boardCopy, scene.getComputer(), 2);
        if (computerIndex != -1) {
            return computerIndex;
        }

        playerIndex = findFork(boardCopy, scene.getPlayer(), 2);
        if (playerIndex != -1) {

            if (boardCopy.getBoard()[4] == boardCopy.getPlayer()) {

                return findFork(boardCopy, scene.getComputer(), 1);

            } else {
                return playerIndex;
            }
        }

        for (int i=0; i<boardCopy.getLength(); i+= 2) {
            if (boardCopy.getBoard()[i] == scene.getPlayer() &&
                    i != 4 && boardCopy.spotAvailable(8 - i)) {
                return 8 - i;
            }
        }

        for (int i=0; i<boardCopy.getLength(); i+= 2) {
            if (i != 4 && boardCopy.spotAvailable(i)) {
                return i;
            }
        }

        for (int i=0; i<boardCopy.getLength(); i++) {
            if (boardCopy.spotAvailable(i)) {
                return i;
            }
        }
        return -1;
    }

    public int findWinPosition(Scene board, char piece) {
        Scene boardCopy = board.copy();
        Scene newBoardCopy;

        for (int i=0; i<boardCopy.getLength(); i++) {
            newBoardCopy = boardCopy.copy();
            if (newBoardCopy.spotAvailable(i)) {
                newBoardCopy.newPiece(piece, i);
                if (newBoardCopy.isWinner(piece) == true) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int findFork(Scene board, char piece, int wins) {
        Scene boardCopy = board.copy();
        Scene newBoardCopy;
        Scene newBoardCopy2;

        int totalWins;

        for (int i=0; i<boardCopy.getLength(); i++) {
            totalWins = 0;
            newBoardCopy = boardCopy.copy();
            if (newBoardCopy.spotAvailable(i)) {
                newBoardCopy.newPiece(piece, i);
            }
            for (int j=0; j<boardCopy.getLength(); j++) {
                newBoardCopy2 = newBoardCopy.copy();
                if (newBoardCopy2.spotAvailable(j)) {
                    newBoardCopy2.newPiece(piece, j);
                    if (newBoardCopy2.isWinner(piece)) {
                        totalWins++;
                    }
                    if (totalWins >= wins) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

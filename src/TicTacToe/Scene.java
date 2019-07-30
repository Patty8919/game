package TicTacToe;

import java.util.Scanner;

public class Scene {
    private char[] board = {' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '};

    private char player;
    private char computer;

    Scene(char player, char computer) {
        this.player = player;
        this.computer = computer;
    }

    char getPlayer() {
        return this.player;
    }

    char getComputer() {
        return this.computer;
    }

    char[] getBoard() {
        return this.board;
    }

    int getLength() {
        return this.board.length;
    }

    void reset() {
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = ' ';
        }
    }

    void newPiece(char piece, int position) {
        this.board[position] = piece;
    }

    boolean spotAvailable(int position) {
        return this.board[position] != this.player &&
                this.board[position] != this.computer;
    }

    boolean isWinner(char piece) {
        for (int i = 0; i < 3; i++) {

            if (this.board[3 * i] == piece && this.board[3 * i + 1] == piece &&
                    this.board[3 * i + 2] == piece || this.board[i] == piece &&
                    this.board[i + 3] == piece && this.board[i + 6] == piece) {
                return true;
            }
        }

        if (this.board[2] == piece && this.board[4] == piece &&
                this.board[6] == piece || this.board[0] == piece &&
                this.board[4] == piece && this.board[8] == piece) {
            return true;

        }
        return false;
    }

    Scene copy() {
        Scene newScene = new Scene(this.player, this.computer);
        for (int i = 0; i < this.board.length; i++) {
            newScene.board[i] = this.board[i];
        }
        return newScene;
    }

    public String toString() {
        String sceneString = "\n";
        for (int i = 0; i < this.board.length; i++) {
            sceneString += " " + this.board[i];

            if (i % 3 == 2 && i != this.board.length - 1) {
                sceneString += "\n" + "---|---|---\n";
            } else if (i != this.board.length - 1) {
                sceneString += " |";
            }
        }
        return sceneString;
    }
}
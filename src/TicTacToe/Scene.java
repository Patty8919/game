package TicTacToe;

public class Scene {
    private char[] board = {' ',' ',' ',
            ' ',' ',' ',
            ' ',' ',' '};

    private char player;
    private char computer;

    public Scene (char player, char computer) {
        this.player = player;
        this.computer = computer;
    }
    public char getPlayer() {
        return this.player;
    }
    public char getComputer() {
        return this.computer;
    }
    public char[] getBoard() {
        return this.board;
    }
    public int getLength() {
        return this.board.length;
    }
    public void reset() {
        for (int i=0; i<this.board.length; i++) {
            this.board[i] = ' ';
        }
    }

    public void newPiece(char piece, int position) {
        this.board[position] = piece;
    }

    public boolean spotAvailable(int position) {
        return this.board[position] != this.player &&
                this.board[position] != this.computer;
    }

    public boolean isWinner(char piece) {
        for (int i=0;i<3;i++) {

            if (this.board[3*i] == piece && this.board[3*i+1] == piece &&
                    this.board[3*i+2] == piece || this.board[i] == piece &&
                    this.board[i+3] == piece && this.board[i+6] == piece) {
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

    public Scene copy() {
        Scene newScene = new Scene(this.player, this.computer);
        for (int i=0; i<this.board.length; i++) {
            newScene.board[i] = this.board[i];
        }
        return newScene;
    }

    public String toString() {
        String sceneString = "\n";
        for (int i=0; i<this.board.length; i++) {
            sceneString += " " + this.board[i];

            if (i % 3 == 2 && i != this.board.length - 1) {
                sceneString += "\n" + "---|---|---\n";
            } else  if (i != this.board.length - 1){
                sceneString += " |";
            }
        }
        return sceneString;
    }
}

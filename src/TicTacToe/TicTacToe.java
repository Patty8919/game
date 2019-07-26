package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {

    //private static final long serialVersionUID = -5034718198692604252L;
    JButton[] boardButtons = new JButton[9];
    JButton resetButton = new JButton("Reset");
    JFrame frame = new JFrame("Tic Tac Toe");

    Scene board = new Scene('X', 'O');
    Computer opponent = new Computer();

    public TicTacToe() {
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private void initialise() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gameBoard = new JPanel(new GridLayout(3,3));

        frame.add(mainPanel);

        gameBoard.setPreferredSize(new Dimension(500,500));

        mainPanel.add(gameBoard, BorderLayout.NORTH);
        mainPanel.add(resetButton);

        resetButton.addActionListener(new myActionListener());

        for(int i=0; i<9; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].setBackground(Color.WHITE);
            boardButtons[i].setText("");
            boardButtons[i].setVisible(true);

            gameBoard.add(boardButtons[i]);
            boardButtons[i].addActionListener(new myActionListener());
            boardButtons[i].setFont(new Font("Tahoma", Font.BOLD, 100));
        }
    }

    private class myActionListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            int computerMove;

            for (int i=0; i<9; i++) {
                if (action.getSource() == boardButtons[i] &&
                        board.spotAvailable(i)) {

                    board.newPiece(board.getPlayer(), i);
                    boardButtons[i].setText(Character.toString(board.getPlayer()));
                    boardButtons[i].setForeground(Color.RED);

                    if (board.isWinner(board.getPlayer())) {
                        gameOver();
                    }

                    computerMove = opponent.getMove(board);

                    if (computerMove != -1) {
                        board.newPiece(board.getComputer(), computerMove);
                        boardButtons[computerMove].setText(Character.toString(board.getComputer()));
                        boardButtons[computerMove].setForeground(Color.BLUE);

                        if (board.isWinner(board.getComputer())) {
                            gameOver();
                        }

                    } else {
                        gameOver();
                    }
                }
            }

            if(action.getSource() == resetButton) {
                for (int i=0; i<9; i++) {
                    boardButtons[i].setText("");
                    boardButtons[i].setEnabled(true);
                    frame.setTitle("Tic Tac Toe");
                }
                board.reset();
            }
        }
    }

    public void gameOver() {
        for (int i=0; i<9; i++) {
            boardButtons[i].setEnabled(false);
        }
        if (board.isWinner(board.getPlayer())) {
            JOptionPane.showMessageDialog(frame, "CONGRATULATIONS! YOU WIN!");
            frame.setTitle("PLAYER WINS");
        } else if (board.isWinner(board.getComputer())) {
            frame.setTitle("COMPUTER WINS");
            JOptionPane.showMessageDialog(frame, "You Lose.");

        } else {
            JOptionPane.showMessageDialog(frame, "Draw.");
            frame.setTitle("IT'S A DRAW");
        }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initialise();
    }
}

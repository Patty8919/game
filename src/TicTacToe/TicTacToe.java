package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class TicTacToe extends JFrame {

        static JButton[] boardButtons = new JButton[9];
        JButton resetButton = new JButton("Reset");
        JButton saveButton = new JButton("Zapisz");
        JButton loadButton = new JButton("Wczytaj");
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
        mainPanel.add(resetButton, BorderLayout.EAST);
        mainPanel.add(loadButton, BorderLayout.CENTER);
        mainPanel.add(saveButton, BorderLayout.WEST);


        resetButton.addActionListener(new MyResetButtonActionListener());
        saveButton.addActionListener(new MySaveButtonActionListener());
        loadButton.addActionListener(new MyLoadButtonActionListener());

        for(int i=0; i<9; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].setBackground(Color.WHITE);
            boardButtons[i].setText("");
            boardButtons[i].setVisible(true);

            gameBoard.add(boardButtons[i]);
            boardButtons[i].addActionListener(new ClickButtonAction(i));
            boardButtons[i].setFont(new Font("Tahoma", Font.BOLD, 100));

        }
    }

    public void gameOver () {
        for (int i = 0; i < 9; i++) {
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

    private class ClickButtonAction implements ActionListener {
        int number = -1;
        int computerMove;
        public ClickButtonAction(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (board.spotAvailable(number)) {
                    board.newPiece(board.getPlayer(), number);
                    boardButtons[number].setText(Character.toString(board.getPlayer()));
                    boardButtons[number].setForeground(Color.RED);

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
        }


    private class MyResetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
                for (int i=0; i<9; i++) {
                    boardButtons[i].setText("");
                    boardButtons[i].setEnabled(true);
                    frame.setTitle("Tic Tac Toe");
                }
                board.reset();
            }
        }

    private class MySaveButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SaveLoad().saveToFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class MyLoadButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new SaveLoad().loadToFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

            public static void main (String[]args){
                TicTacToe game = new TicTacToe();
                game.initialise();

            }
        }


package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static TicTacToe.TicTacToe.boardButtons;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SaveLoad {


    public void saveToFile(JButton[] boardButtons) throws IOException {

        String boardState = "";

        for (int i = 0; i < boardButtons.length; i++) {
            boardState += boardButtons[i].getText();
            if (i != boardButtons.length - 1) {
                boardState += ",";
            }
        }

        File f = new File("Test.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        Path path = f.toPath();

        try (
                BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(boardState);
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }


    public void loadToFile(JButton[] boardButtons) {

        File file1 = new File("Test.txt");
        FileInputStream fis;
        BufferedInputStream bis;

        try {

            fis = new FileInputStream(file1);
            bis = new BufferedInputStream(fis);
            byte[] contents = new byte[17];

            while (bis.available() != 0) {
                bis.read(contents);
            }
            fis.close();
            bis.close();
            String savedState = new String(contents, UTF_8);
            String[] buttonStates = savedState.split(",");
            for (int i = 0; i < boardButtons.length; i++) {
                boardButtons[i].setText(buttonStates[i]);
                System.out.println("! " + buttonStates[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

     public SaveLoad() throws IOException {
    }

}
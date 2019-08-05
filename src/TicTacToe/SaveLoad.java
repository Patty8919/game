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

public class SaveLoad {


    public void saveToFile(JButton[] boardButtons) throws IOException {

            final JButton saveButton = new JButton();
            saveButton.setText("ticTac");

            File f = new File("Test.txt");
            if (!f.exists()) {

            }
            Path path = f.toPath();

            try (
                    BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(String.valueOf(boardButtons));
            } catch (IOException e) {
                System.out.println("wystąpił błąd: " + e);
            }
        }


    public void loadToFile(JButton[] boardButtons) {

        final JButton loadButton = new JButton();
        loadButton.setText("ticTac");
        String string = "X,O,X,O,O,X";
        String[] part = string.split(",");
        String part1 = part[0];

        File file1 = new File("Test.txt");
        FileInputStream fis;
        BufferedInputStream bis;

        try {

            fis = new FileInputStream(file1);
            bis = new BufferedInputStream(fis);

            while (bis.available() != 0) {
                System.out.println(bis);
            }
            fis.close();
            bis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        {

        }
    }


    public SaveLoad() throws IOException {
    }

}
package TicTacToe;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static TicTacToe.TicTacToe.boardButtons;

public class SaveLoad {


    void saveToFile() throws IOException {
        /*String string = "X,O,O - O,X,X";
        String [] parts = string.split("-");
        String part1 = parts[0];
        String part2 = parts[1];*/

        String save = boardButtons();
        
        File f = new File("Test.txt");
        if(!f.exists()) {
            f.createNewFile();
            String state = "X,O,X,O,O,X";
            String [] parts = state.split(",");
            String part = parts[0];

        }
        Path path = f.toPath();

        try (

        BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(save);
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    private String boardButtons() {
        return null;
    }

    void loadToFile(){
        String load = boardButtons();
        String [] parts = load.split(",");
        String part1 = parts[0];

       part1.setText("" + boardButtons);

        File file1 = new File("Test.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        
            try{
  
                 fis = new FileInputStream(file1);
                 bis = new BufferedInputStream(fis);
                 dis = new DataInputStream(bis);

             while (dis.available() !=0) {
                 System.out.println(dis.readLine());
             }
             fis.close();
             bis.close();
             dis.close();
             
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
            {

            }
        }


    public SaveLoad() throws IOException {
    }
}
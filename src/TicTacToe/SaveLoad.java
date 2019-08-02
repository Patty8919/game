package TicTacToe;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class SaveLoad {


    void saveToFail() throws IOException {
        String string = "X,O,O - O,X,X";
        String [] parts = string.split("-");
        String part1 = parts[0];
        String part2 = parts[1];

        //Path path = Paths.get("Test.txt");
        File f = new File("Test.txt");
        if(!f.exists()) {
            f.createNewFile();
        }
        Path path = f.toPath();

        try (

        BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(part1 + part2);
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    void loadToFail(){

        File file1 = new File("Test.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        //Path file = Paths.get(part1 + part2);
            try{
                 //Stream<String> stream = Files.lines(file))
                 fis = new FileInputStream(file1);
                 bis = new BufferedInputStream(fis);
                 dis = new DataInputStream(bis);

             while (dis.available() !=0) {
                 System.out.println(dis.readLine());
             }
             fis.close();
             bis.close();
             dis.close();
                //stream.forEach(System.out::println);

            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
            {

                //System.out.println("wystąpił błąd: " + e);
            }
        }


    public SaveLoad() throws IOException {
    }
}
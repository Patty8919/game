package TicTacToe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Rank {
    Path path = Paths.get("c:/output.txt");

        try(
    BufferedWriter writer = Files.newBufferedWriter(path))

    {
        writer.write("Zapisuje wynik");
    } catch(IOException e)

    {
        System.out.println("wystąpił błąd: " + e);
    }

    Path file = Paths.get("c://output.txt");

        try(
    Stream<String> stream = Files.lines(file))

    {

        stream.forEach(System.out::println);

    } catch(IOException e)

    {
        System.out.println("wystąpił błąd: " + e);
    }

    public Rank() throws IOException {
    }
}
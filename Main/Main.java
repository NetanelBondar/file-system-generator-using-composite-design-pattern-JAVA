package Main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * this is a program that simulates a file system creation.
 */
public class Main {
    public static void main(String[] args) {

        FoldersManager foldersManager = new FoldersManager();

        Scanner reader = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        String line;

        System.out.println("Enter file/directory paths (or 'exit' to quit):");
        while (true) {

            line = reader.nextLine();

            if (line.equals("exit")) {
                break;
            }

            inputs.add(line);
        }

        for (String input : inputs) {
            foldersManager.addPath(input);
        }

        foldersManager.printTree();
    }
}
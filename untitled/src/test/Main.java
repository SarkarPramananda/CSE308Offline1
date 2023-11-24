package test;

import accountPackage.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("in.txt"));
            String input =scanner.nextLine();
            System.out.println(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

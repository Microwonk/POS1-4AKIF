package Tuefteln.math_test;

import Tuefteln.parser.Parser;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Parser.simpleEval(new Scanner(System.in).nextLine()));
        }
    }
}

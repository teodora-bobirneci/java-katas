package katas.twitter;

import java.util.List;
import java.util.Scanner;

public class Console {
    public static final List<String> EXIT_COMMANDS = List.of("exit", "quit", "bye");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Twitter twitter = new Twitter();
        String command = null;
        while (isExitCommand(command)) {
            command = scanner.nextLine();

        }
    }


    private static boolean isExitCommand(String command) {
        return EXIT_COMMANDS.contains(command);
    }
}

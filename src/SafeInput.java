import java.util.Scanner;

public class SafeInput {
    private static Scanner in = new Scanner(System.in);

    public static String getRegExString(String prompt, String regex) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine();
        } while (!input.matches(regex));
        return input;
    }

    public static int getRangedInt(String prompt, int low, int high) {
        int value;
        do {
            System.out.print(prompt);
            while (!in.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                in.next(); // clear invalid input
                System.out.print(prompt);
            }
            value = in.nextInt();
            in.nextLine(); // clear buffer
        } while (value < low || value > high);
        return value;
    }

    public static String getNonZeroLenString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine();
        } while (input.trim().isEmpty());
        return input;
    }

    public static boolean getYNConfirm(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}


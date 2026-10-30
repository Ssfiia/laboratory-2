import java.util.Scanner;
public class Input {
    private static final Scanner SC = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  Ошибка: введите целое число.");
            }
        }
    }

    public static int readNonNegativeInt(String prompt) {
        while (true) {
            int v = readInt(prompt);
            if (v >= 0) return v;
            System.out.println("  Ошибка: число должно быть неотрицательным.");
        }
    }

    public static int readPositiveInt(String prompt) {
        while (true) {
            int v = readInt(prompt);
            if (v > 0) return v;
            System.out.println("  Ошибка: число должно быть положительным.");
        }
    }

    public static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("  Ошибка: строка не должна быть пустой.");
        }
    }

    public static String readOptionalString(String prompt) {
        System.out.print(prompt);
        String s = SC.nextLine().trim();
        return s.isEmpty() ? null : s;
    }
}


package others;

import java.util.Scanner;

public class CountStick {

    public static void main(String[] args) {
        System.out.println(getExpression().getTransform());
    }

    private static AddExpresion getExpression() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        AddExpresion expresion = new AddExpresion();
        int status = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '=') {
                status++;
                continue;
            }
            if (status == 0) {
                expresion.addToA();
                continue;
            }
            if (status == 1) {
                expresion.addToB();
                continue;
            }
            if (status == 2) {
                expresion.addToC();
            }
        }
        return expresion;
    }

    private static class AddExpresion {
        String a = "", b = "", c = "";

        void addToA() {
            a = a + "|";
        }

        void addToB() {
            b = b + "|";
        }

        void addToC() {
            c = c + "|";
        }

        String getTransform() {
            final int diff = a.length() + b.length() - c.length();
            if (diff != 0 && Math.abs(diff) != 2) {
                return "Impossible";
            }
            if (diff == 2) {
                if (a.length() > 1) {
                    a = a.substring(0, a.length() - 1);
                } else {
                    b = b.substring(0, b.length() - 1);
                }
                addToC();
            }
            if (diff == -2) {
                addToA();
                c = c.substring(0, c.length() - 1);
            }
            return a + "+" + b + "=" + c;
        }
    }
}

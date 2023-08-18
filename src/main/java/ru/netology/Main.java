package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        PasswordChecker pass = new PasswordChecker();
        try {
            System.out.print("Введите мin. длину пароля: ");
            String minLengthSet = scanner.nextLine();
            int minLength = Integer.parseInt(minLengthSet);
            pass.setMinLength(minLength);
        } catch (IllegalArgumentException exception) {
            System.out.println("Введено недопустимое значение.");
        }
        try {
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            String maxRepeatsSet = scanner.nextLine();
            int maxRepeats = Integer.parseInt(maxRepeatsSet);
            pass.setMaxRepeats(maxRepeats);

        } catch (IllegalArgumentException exception) {
            System.out.println("Введено недопустимое значение.");
        }


        while (true) {
            try {
                System.out.print("Введите пароль или end: ");
                String password = scanner.nextLine();
                if ("end".equals(password)) {
                    break;
                }
                pass.verify(password);
            } catch (IllegalStateException exception) {
                System.out.println("Не были заданы исходные данные для создания пароля");
            }
        }
        System.out.println("Программа завершена");
    }
}
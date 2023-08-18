package ru.netology;

public class PasswordChecker {

    private int minLength;
    private int maxRepeats;

    private int setterVoid = 0;

    public void setMinLength(int minLength) throws Exception {
        if (minLength < 0) {
            throw new IllegalArgumentException("Введено недопустимое значение. Длина пароля должны быть >0 ");
        }
        this.minLength = minLength;
        setterVoid++;
    }

    public void setMaxRepeats(int maxRepeats) throws Exception {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Введено недопустимое значение.");
        }
        this.maxRepeats = maxRepeats;

    }


    public boolean verify(String password) throws Exception {
        int count = 1;
        if (setterVoid == 0) {
            throw new IllegalStateException("Не были заданы исходные данные для создания пароля");
        }
        if (maxRepeats == 0) {
            throw new IllegalStateException("Не были заданы исходные данные для создания пароля");
        }
        if (password.length() >= minLength) {
            for (int i = 0; i <= password.length() - maxRepeats; i++) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    count++;
                    if (count > maxRepeats) {
                        System.out.println("Не подходит");
                        return false;
                    }
                } else {
                    count = 1;
                }
            }
            System.out.println("Подходит");
        } else {
            System.out.println("Не подходит");
        }
        return true;
    }
}

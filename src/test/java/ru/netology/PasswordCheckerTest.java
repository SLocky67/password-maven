package ru.netology;

import org.junit.jupiter.api.Assertions;


class PasswordCheckerTest {

    @org.junit.jupiter.api.Test
    public void testVerify_validPassword_success() throws Exception {
        // given:
        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.setMinLength(6);
        passwordChecker.setMaxRepeats(2);

        // when:
        boolean result = passwordChecker.verify("abcdde");

        // then:
        Assertions.assertTrue(result);
    }



    @org.junit.jupiter.api.Test
    public void testVerify_invalidPassword_lengthTooShort() throws Exception {
        // given:
        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.setMinLength(8);
        passwordChecker.setMaxRepeats(2);

        // when:
        boolean result = passwordChecker.verify("arterfgdgdgdb");

        // then:
        Assertions.assertTrue(result);
    }






    @org.junit.jupiter.api.Test
    public void testVerify_invalidPassword_tooManyRepeats() throws Exception {
        // given:
        PasswordChecker passwordChecker = new PasswordChecker();
        passwordChecker.setMinLength(6);
        passwordChecker.setMaxRepeats(2);

        // when:
        boolean result = passwordChecker.verify("abccccccc");

        // then:
        Assertions.assertFalse(result);
    }
}
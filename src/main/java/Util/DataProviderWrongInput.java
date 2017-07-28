package Util;

import org.testng.annotations.DataProvider;

public class DataProviderWrongInput {
    @DataProvider(name = "errorEmailInput")
    public static Object[][] wrongEmailInput() {
        return new Object[][]{
                {"kek", "Please use between 6 and 30 characters."},
                {"lol@kek", "Please use only letters (a-z), numbers, and periods."},
                {"ohoho@lol.kek", "This email address already corresponds to a Google Account. " +
                        "Please sign in or, if you forgot your password, reset it."},
                {"ivan...tiran", "A fan of punctuation! Alas, usernames can't have consecutive periods."},
                {"iamselenium", "That username is taken. Try another."},
                {"iamselenium.", "The last character of your username should be a letter (a-z) or number."},
                {".iamselenium", "The first character of your username should be a letter (a-z) or number."},
                {"kekkek@kek.lol", "That looks like your email address. You can enter that below. " +
                        "Choose a new Google username (which will also be your new gmail.com address)."}
        };
    }

    @DataProvider(name = "errorPasswdInput")
    public static Object[][] wrongPasswdInput() {
        return new Object[][]{
                {"idiot", "Short passwords are easy to guess. Try one with at least 8 characters."},
                {"000000000", "Common words are easy to guess. Try again?"}
        };
    }

    @DataProvider(name = "errorRecoveryMailInput")
    public static Object[][] wrongRecoveryMailInput() {
        return new Object[][]{
                {"ololo@@ahah..asd", "A fan of the @ sign! But please use only one in the email address."},
                {"sad..sad@lol.com", "This email address is not valid."},
                {"lol..asd@ad", "Your email address contains the invalid domain name 'ad'."},
                {"lol..lol", "Enter your full email address, including the '@'."},
                {"galera@", "Don't forget the part after the '@'."}
        };
    }
}

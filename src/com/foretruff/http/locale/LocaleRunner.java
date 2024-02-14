package com.foretruff.http.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) {
//        Locale locale = new Locale("uk","UA");
        Locale locale = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
        System.out.println(Locale.UK);
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translations", locale); // ???????? ???? ?? ???????
        System.out.println(translations.getString("page.login.password"));
    }
}

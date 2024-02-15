package com.foretruff.http.locale;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        Locale locale = new Locale("uk","UA");
        System.setProperty("file.encoding", "UTF-8");
        Locale locale = new Locale.Builder().setLanguage("de").setRegion("LU").build();
        System.out.println(Locale.UK);
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translation", locale);
        var value = translations.getString("page.login.password");
//        var string = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(value);

    }
}

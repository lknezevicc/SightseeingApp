package hr.tis.academy.hackaton.sightseeingapp.util;

import java.text.Normalizer;

public class DiacriticsConverter {

    public static String convertToAscii(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        input = Normalizer.normalize(input, Normalizer.Form.NFD);

        for (char c : input.toCharArray()) {
            if (c <= '\u007F') sb.append(c);
        }

        return sb.toString();
    }

}


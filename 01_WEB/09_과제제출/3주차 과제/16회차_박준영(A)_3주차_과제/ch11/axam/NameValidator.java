package ch11.axam;

import java.util.regex.Pattern;

public class NameValidator {
    public static void validate(String name) throws InvalidNameException {
        String regex = "^[가-힣]{2,10}$";

        if (!Pattern.matches(regex, name)) {
            throw new InvalidNameException("이름은 한글 2~10자여야 합니다.");
        }
    }
}

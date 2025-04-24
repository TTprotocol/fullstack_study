package ch11.axam;

public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException(String message) {
//        super(message);
        System.out.println(message);
    }
}

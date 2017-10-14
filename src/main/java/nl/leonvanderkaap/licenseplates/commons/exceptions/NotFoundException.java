package nl.leonvanderkaap.licenseplates.commons.exceptions;

public class NotFoundException extends RuntimeException{

    private String text;

    public NotFoundException(String text) {
        super(text);
        this.text = text;
    }
}

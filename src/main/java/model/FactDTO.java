package model;

public class FactDTO {
    private String text;
    private String type;

    public FactDTO() {
    }

    public FactDTO(String text, String type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }
}

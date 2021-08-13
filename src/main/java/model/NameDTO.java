package model;

public class NameDTO {
    private String first;
    private String last;

    public NameDTO(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public NameDTO() {
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}

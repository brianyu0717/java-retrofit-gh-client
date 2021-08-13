package model;

public class UserDTO {
    private NameDTO name;

    public UserDTO() {
    }

    public UserDTO(NameDTO name) {
        this.name = name;
    }

    public NameDTO getName() {
        return name;
    }
}

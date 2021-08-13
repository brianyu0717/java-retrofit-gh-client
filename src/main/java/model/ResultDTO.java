package model;

import java.util.List;

public class ResultDTO {
    private List<UserDTO> results;

    public ResultDTO(List<UserDTO> results) {
        this.results = results;
    }

    public ResultDTO() {
    }

    public List<UserDTO> getResults() {
        return results;
    }
}

package br.unit.forgek.dto;

public class StatusDTO {
    private Long id;
    private String status;

    public StatusDTO(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

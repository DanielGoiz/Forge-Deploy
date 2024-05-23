package br.unit.forgek.dto;

public class TecnologiaDTO {
    private Long id;
    private String tecnologia;

    public TecnologiaDTO(Long id, String tecnologia) {
        this.id = id;
        this.tecnologia = tecnologia;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}

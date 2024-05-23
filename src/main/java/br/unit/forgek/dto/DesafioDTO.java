package br.unit.forgek.dto;

public class DesafioDTO {
    private Long id;
    private String desafio;

    public DesafioDTO(Long id, String desafio) {
        this.id = id;
        this.desafio = desafio;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesafio() {
        return desafio;
    }

    public void setDesafio(String desafio) {
        this.desafio = desafio;
    }
}

package br.unit.forgek.dto;

public class MaterialDeEstudoDTO {
    private Long id;
    private String materialDeEstudo;

    public MaterialDeEstudoDTO(Long id, String materialDeEstudo) {
        this.id = id;
        this.materialDeEstudo = materialDeEstudo;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialDeEstudo() {
        return materialDeEstudo;
    }

    public void setMaterialDeEstudo(String materialDeEstudo) {
        this.materialDeEstudo = materialDeEstudo;
    }
}

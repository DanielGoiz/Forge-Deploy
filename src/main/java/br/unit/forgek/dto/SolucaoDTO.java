package br.unit.forgek.dto;

public class SolucaoDTO {
    private Long id;
    private String solucao;

    public SolucaoDTO(Long id, String solucao) {
        this.id = id;
        this.solucao = solucao;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
}

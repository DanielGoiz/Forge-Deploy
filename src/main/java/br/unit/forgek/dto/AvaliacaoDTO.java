package br.unit.forgek.dto;

public class AvaliacaoDTO {
    private Long id;
    private String avaliacao;

    public AvaliacaoDTO(Long id, String avaliacao) {
        this.id = id;
        this.avaliacao = avaliacao;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}

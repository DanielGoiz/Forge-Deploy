package br.unit.forgek.dto;

import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.modelo.Mentor;

public class DesafioCompletoDTO {

    private Long id;
    private String desafio;
    private String solucao;
    private String tecnologia;
    private String materialDeEstudo;
    private String video;
    private String status;
    private String avaliacao;
    private Mentor mentor;
    private Empresa empresa;

    // Construtor completo
    public DesafioCompletoDTO(Long id, String desafio, String solucao, String tecnologia, String materialDeEstudo, String video, String status, String avaliacao, Mentor mentor, Empresa empresa) {
        this.id = id;
        this.desafio = desafio;
        this.solucao = solucao;
        this.tecnologia = tecnologia;
        this.materialDeEstudo = materialDeEstudo;
        this.video = video;
        this.status = status;
        this.avaliacao = avaliacao;
        this.mentor = mentor;
        this.empresa = empresa;
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

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getMaterialDeEstudo() {
        return materialDeEstudo;
    }

    public void setMaterialDeEstudo(String materialDeEstudo) {
        this.materialDeEstudo = materialDeEstudo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

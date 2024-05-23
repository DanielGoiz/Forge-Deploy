package br.unit.forgek.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "desafios")
public class DesafiosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesafio;

    private String desafio;
    private String solucao;
    private String tecnologia;
    private String materialDeEstudo;
    private String video;
    private String status;
    private String avaliacao;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // Getters and setters

    public Long getId() {
        return idDesafio;
    }

    public void setId(Long id) {
        this.idDesafio = id;
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

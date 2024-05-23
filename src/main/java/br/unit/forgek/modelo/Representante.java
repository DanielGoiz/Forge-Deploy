package br.unit.forgek.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do Representante é obrigatório")
    @Size(min = 2, message = "O nome da Representante deve ter ao menos 2 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
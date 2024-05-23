package br.unit.forgek.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da empresa é obrigatório")
    @Size(min = 2, message = "O nome da empresa deve ter ao menos 2 caracteres")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
    private String cnpj;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    // Getters e Setters

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
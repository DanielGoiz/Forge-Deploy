package br.unit.forgek.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Transient;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do Mentor é obrigatório")
    @Size(min = 2, message = "O nome do Mentor deve ter ao menos 2 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    private String especialidade;

    @OneToMany(mappedBy = "mentor", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HorarioDisponivel> horariosDisponiveis = new ArrayList<>();

    @Transient
    private Long empresaId;

    @ManyToOne
    private Empresa empresa;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<HorarioDisponivel> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<HorarioDisponivel> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    // Métodos para adicionar e remover horários
    public void addHorarioDisponivel(HorarioDisponivel horario) {
        horariosDisponiveis.add(horario);
        horario.setMentor(this);
    }

    public void removeHorarioDisponivel(HorarioDisponivel horario) {
        horariosDisponiveis.remove(horario);
        horario.setMentor(null);
    }
}

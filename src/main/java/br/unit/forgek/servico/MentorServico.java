package br.unit.forgek.servico;

import br.unit.forgek.modelo.Mentor;
import br.unit.forgek.modelo.HorarioDisponivel;
import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.repositorio.MentorRepositorio;
import br.unit.forgek.repositorio.HorarioDisponivelRepositorio;
import br.unit.forgek.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServico {

    private final MentorRepositorio mentorRepositorio;
    private final HorarioDisponivelRepositorio horarioDisponivelRepositorio;
    private final EmpresaRepositorio empresaRepositorio; // Adicionado para gerenciar a associação com Empresa

    @Autowired
    public MentorServico(MentorRepositorio mentorRepositorio, HorarioDisponivelRepositorio horarioDisponivelRepositorio, EmpresaRepositorio empresaRepositorio) {
        this.mentorRepositorio = mentorRepositorio;
        this.horarioDisponivelRepositorio = horarioDisponivelRepositorio;
        this.empresaRepositorio = empresaRepositorio;
    }
    public List<Mentor> listarTodos() {
        return mentorRepositorio.findAll();
    }

    public Optional<Mentor> buscarPorId(Long id) {
        return mentorRepositorio.findById(id);
    }

    public Mentor criarMentor(Mentor mentor, Long empresaId) {
        Empresa empresa = empresaRepositorio.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para este id :: " + empresaId));
        mentor.setEmpresa(empresa);
        return mentorRepositorio.save(mentor);
    }

    public Mentor atualizarMentor(Long id, Mentor mentorDetalhes, Long empresaId) {
        Mentor mentor = mentorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor não encontrado para este id :: " + id));
        Empresa empresa = empresaRepositorio.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para este id :: " + empresaId));

        mentor.setNome(mentorDetalhes.getNome());
        mentor.setEmail(mentorDetalhes.getEmail());
        mentor.setEspecialidade(mentorDetalhes.getEspecialidade());
        mentor.setEmpresa(empresa); // Atualiza a empresa associada ao mentor

        return mentorRepositorio.save(mentor);
    }

    public void deletarMentor(Long id) {
        Mentor mentor = mentorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor não encontrado para este id :: " + id));
        mentorRepositorio.delete(mentor);
    }

    public HorarioDisponivel adicionarHorario(Long mentorId, HorarioDisponivel horario) {
        Mentor mentor = mentorRepositorio.findById(mentorId).orElseThrow(() -> new RuntimeException("Mentor não encontrado para este id :: " + mentorId));
        horario.setMentor(mentor);
        return horarioDisponivelRepositorio.save(horario);
    }

    public List<HorarioDisponivel> listarHorarios(Long mentorId) {
        return horarioDisponivelRepositorio.findByMentorId(mentorId);
    }

    public boolean removerHorario(Long horarioId) {
        if (horarioDisponivelRepositorio.existsById(horarioId)) {
            horarioDisponivelRepositorio.deleteById(horarioId);
            return true;
        } else {
            return false;
        }
    }

    public HorarioDisponivel atualizarHorario(Long horarioId, HorarioDisponivel horarioDetalhes) {
        HorarioDisponivel horario = horarioDisponivelRepositorio.findById(horarioId)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado para este id :: " + horarioId));

        horario.setDiaDaSemana(horarioDetalhes.getDiaDaSemana());
        horario.setInicio(horarioDetalhes.getInicio());
        horario.setFim(horarioDetalhes.getFim());
        horario.setMentor(horarioDetalhes.getMentor());

        return horarioDisponivelRepositorio.save(horario);
    }
}


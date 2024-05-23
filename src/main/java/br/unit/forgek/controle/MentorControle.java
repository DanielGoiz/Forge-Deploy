package br.unit.forgek.controle;

import br.unit.forgek.modelo.HorarioDisponivel;
import br.unit.forgek.modelo.Mentor;
import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.servico.MentorServico;
import br.unit.forgek.servico.EmpresaServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/mentores")
public class MentorControle {

    private final MentorServico mentorServico;
    private final EmpresaServico empresaServico;

    public MentorControle(MentorServico mentorServico, EmpresaServico empresaServico) {
        this.mentorServico = mentorServico;
        this.empresaServico = empresaServico;
    }

    @PostMapping
    public ResponseEntity<Mentor> criarMentor(@RequestBody Mentor mentor, @RequestParam Long empresaId) {
        Empresa empresa = empresaServico.buscarPorId(empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
        mentor.setEmpresa(empresa);
        Mentor novoMentor = mentorServico.criarMentor(mentor, empresaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMentor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentor> atualizarMentor(@PathVariable Long id, @RequestBody Mentor mentorDetalhes, @RequestParam Long empresaId) {
        Empresa empresa = empresaServico.buscarPorId(empresaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
        mentorDetalhes.setEmpresa(empresa);
        Mentor mentorAtualizado = mentorServico.atualizarMentor(id, mentorDetalhes, empresaId);
        return ResponseEntity.ok(mentorAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Mentor>> listarTodosMentores() {
        List<Mentor> mentores = mentorServico.listarTodos();
        return ResponseEntity.ok(mentores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentor> buscarMentorPorId(@PathVariable Long id) {
        return mentorServico.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMentor(@PathVariable Long id) {
        mentorServico.deletarMentor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{mentorId}/horarios")
    public ResponseEntity<HorarioDisponivel> adicionarHorario(@PathVariable Long mentorId, @RequestBody HorarioDisponivel horario) {
        HorarioDisponivel novoHorario = mentorServico.adicionarHorario(mentorId, horario);
        if (novoHorario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(novoHorario);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{mentorId}/horarios")
    public ResponseEntity<List<HorarioDisponivel>> listarHorarios(@PathVariable Long mentorId) {
        List<HorarioDisponivel> horarios = mentorServico.listarHorarios(mentorId);
        if (horarios != null && !horarios.isEmpty()) {
            return ResponseEntity.ok(horarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/horarios/{horarioId}")
    public ResponseEntity<Void> removerHorario(@PathVariable Long horarioId) {
        boolean sucesso = mentorServico.removerHorario(horarioId);
        if (sucesso) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/horarios/{horarioId}")
    public ResponseEntity<HorarioDisponivel> atualizarHorario(@PathVariable Long horarioId, @RequestBody HorarioDisponivel horarioDetalhes) {
        try {
            HorarioDisponivel horarioAtualizado = mentorServico.atualizarHorario(horarioId, horarioDetalhes);
            return ResponseEntity.ok(horarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

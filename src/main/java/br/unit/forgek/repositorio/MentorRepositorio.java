package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepositorio extends JpaRepository<Mentor, Long>{
}
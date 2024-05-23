package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.DesafiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafiosRepository extends JpaRepository<DesafiosEntity, Long> {
}
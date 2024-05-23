package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteRepositorio  extends JpaRepository<Representante, Long> {

}
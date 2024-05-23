package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}

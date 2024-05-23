package br.unit.forgek.servico;
import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServico {

    private final EmpresaRepositorio empresaRepositorio;

    public EmpresaServico(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    public Empresa criarEmpresa(Empresa empresa) {
        empresaRepositorio.save(empresa);
        return empresa;
    }

    public List<Empresa> listarTodas() {
        return empresaRepositorio.findAll();
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepositorio.findById(id);
    }

    public Empresa atualizarEmpresa(Long id, Empresa empresaDetalhes) {
        Empresa empresa = empresaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para este id :: " + id));
        empresa.setNome(empresaDetalhes.getNome());
        empresa.setCnpj(empresaDetalhes.getCnpj());
        empresa.setEndereco(empresaDetalhes.getEndereco());
        empresa.setEmail(empresaDetalhes.getEmail());
        return empresaRepositorio.save(empresa);
    }

    public void deletarEmpresa(Long id) {
        Empresa empresa = empresaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para este id :: " + id));
        empresaRepositorio.delete(empresa);
    }
}
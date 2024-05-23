package br.unit.forgek.servico;

import br.unit.forgek.dto.*;
import br.unit.forgek.modelo.DesafiosEntity;
import br.unit.forgek.modelo.Mentor;
import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.repositorio.DesafiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesafiosService {

    @Autowired
    private DesafiosRepository desafiosRepository;

    public DesafioCompletoDTO criarDesafio(DesafioCompletoDTO desafioCompleteDTO, Mentor mentor, Empresa empresa) {
        DesafiosEntity desafiosEntity = getDesafiosEntity(desafioCompleteDTO, mentor, empresa);
        DesafiosEntity desafiosEntitySaved = desafiosRepository.save(desafiosEntity);
        return new DesafioCompletoDTO(desafiosEntitySaved.getId(),
                desafiosEntitySaved.getDesafio(),
                desafiosEntitySaved.getSolucao(),
                desafiosEntitySaved.getTecnologia(),
                desafiosEntitySaved.getMaterialDeEstudo(),
                desafiosEntitySaved.getVideo(),
                desafiosEntitySaved.getStatus(),
                desafiosEntitySaved.getAvaliacao(),
                desafiosEntitySaved.getMentor(),
                desafiosEntitySaved.getEmpresa());
    }

    private static DesafiosEntity getDesafiosEntity(DesafioCompletoDTO desafioCompleteDTO, Mentor mentor, Empresa empresa) {
        DesafiosEntity desafiosEntity = new DesafiosEntity();
        desafiosEntity.setDesafio(desafioCompleteDTO.getDesafio());
        desafiosEntity.setSolucao(desafioCompleteDTO.getSolucao());
        desafiosEntity.setTecnologia(desafioCompleteDTO.getTecnologia());
        desafiosEntity.setMaterialDeEstudo(desafioCompleteDTO.getMaterialDeEstudo());
        desafiosEntity.setVideo(desafioCompleteDTO.getVideo());
        desafiosEntity.setStatus(desafioCompleteDTO.getStatus());
        desafiosEntity.setAvaliacao(desafioCompleteDTO.getAvaliacao());
        desafiosEntity.setMentor(mentor);
        desafiosEntity.setEmpresa(empresa);
        return desafiosEntity;
    }

    public List<DesafioCompletoDTO> getAllDesafios() {
        return desafiosRepository.findAll().stream()
                .map(desafiosEntity -> new DesafioCompletoDTO(desafiosEntity.getId(),
                        desafiosEntity.getDesafio(),
                        desafiosEntity.getSolucao(),
                        desafiosEntity.getTecnologia(),
                        desafiosEntity.getMaterialDeEstudo(),
                        desafiosEntity.getVideo(),
                        desafiosEntity.getStatus(),
                        desafiosEntity.getAvaliacao(),
                        desafiosEntity.getMentor(),
                        desafiosEntity.getEmpresa()))
                .collect(Collectors.toList());
    }

    public DesafioCompletoDTO getDesafioById(Long id) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        return new DesafioCompletoDTO(desafiosEntity.getId(),
                desafiosEntity.getDesafio(),
                desafiosEntity.getSolucao(),
                desafiosEntity.getTecnologia(),
                desafiosEntity.getMaterialDeEstudo(),
                desafiosEntity.getVideo(),
                desafiosEntity.getStatus(),
                desafiosEntity.getAvaliacao(),
                desafiosEntity.getMentor(),
                desafiosEntity.getEmpresa());
    }

    public DesafioDTO atualizarDesafio(Long idDesafio, DesafioDTO desafioDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setDesafio(desafioDTO.getDesafio());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new DesafioDTO(updatedDesafio.getId(), updatedDesafio.getDesafio());
    }

    public SolucaoDTO atualizarSolucao(Long idDesafio, SolucaoDTO solucaoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setSolucao(solucaoDTO.getSolucao());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new SolucaoDTO(updatedDesafio.getId(), updatedDesafio.getSolucao());
    }

    public TecnologiaDTO atualizarTecnologia(Long idDesafio, TecnologiaDTO tecnologiaDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setTecnologia(tecnologiaDTO.getTecnologia());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new TecnologiaDTO(updatedDesafio.getId(), updatedDesafio.getTecnologia());
    }

    public MaterialDeEstudoDTO atualizarMaterialDeEstudo(Long idDesafio, MaterialDeEstudoDTO materialDeEstudoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setMaterialDeEstudo(materialDeEstudoDTO.getMaterialDeEstudo());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new MaterialDeEstudoDTO(updatedDesafio.getId(), updatedDesafio.getMaterialDeEstudo());
    }

    public VideoDTO atualizarVideo(Long idDesafio, VideoDTO videoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setVideo(videoDTO.getVideo());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new VideoDTO(updatedDesafio.getId(), updatedDesafio.getVideo());
    }

    public StatusDTO atualizarStatus(Long idDesafio, StatusDTO statusDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setStatus(statusDTO.getStatus());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new StatusDTO(updatedDesafio.getId(), updatedDesafio.getStatus());
    }

    public AvaliacaoDTO atualizarAvaliacao(Long idDesafio, AvaliacaoDTO avaliacaoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setAvaliacao(avaliacaoDTO.getAvaliacao());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new AvaliacaoDTO(updatedDesafio.getId(), updatedDesafio.getAvaliacao());
    }

    public void excluirDesafio(Long idDesafio) {
        desafiosRepository.deleteById(idDesafio);
    }
}

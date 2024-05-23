package br.unit.forgek.controle;

import br.unit.forgek.modelo.Representante;
import br.unit.forgek.servico.RepresentanteServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/representantes") // Define a base path para todos os métodos deste controlador
@Controller
public class RepresentanteControle {



    private final RepresentanteServico representanteServico;

    public RepresentanteControle(RepresentanteServico representanteServico) {
        this.representanteServico = representanteServico;
    }
    @PostMapping("/representantes/{empresaId}")
    public ResponseEntity<Representante> criarRepresentante(@PathVariable(value = "empresaId") Long empresaId, @RequestBody Representante representante) {
        Representante novoRepresentante = representanteServico.criarRepresentante(representante, empresaId);
        return new ResponseEntity<>(novoRepresentante, HttpStatus.CREATED);
    }

    @GetMapping // Mapeia requisições GET para /empresas
    public ResponseEntity<List<Representante>> listarTodosRepresentantes() {
        List<Representante> representantes = representanteServico.listarTodas();
        return ResponseEntity.ok(representantes); // Retorna a lista de empresas com status 200 OK
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /empresas/{id}
    public ResponseEntity<Representante> buscarRepresentantePorId(@PathVariable Long id) {
        return representanteServico.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Representante não encontrada"));
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /empresas/{id}
    public ResponseEntity<Representante> atualizarRepresentante(@PathVariable Long id, @RequestBody Representante representanteDetalhes) {
        Representante representanteAtualizado = representanteServico.atualizarRepresentante(id, representanteDetalhes);
        return ResponseEntity.ok(representanteAtualizado); // Retorna a empresa atualizada com status 200 OK
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /empresas/{id}
    public ResponseEntity<Void> deletarRepresentante(@PathVariable Long id) {
        representanteServico.deletarRepresentante(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }

}
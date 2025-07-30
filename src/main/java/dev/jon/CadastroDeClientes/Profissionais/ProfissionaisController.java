package dev.jon.CadastroDeClientes.Profissionais;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionaisController {

    private final ProfissionaisService profissionaisService;

    public ProfissionaisController(ProfissionaisService profissionaisService) {
        this.profissionaisService = profissionaisService;
    }

    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem teste", description = "Testa rapidamente se o controller está funcionando corretamente")
    public String boasVindas() {
        return "Teste mensagem na rota de profissionais";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um profissional", description = "Esta rota cria um novo profissional e insere no banco de dados")
    public ResponseEntity<String> criarProfissional(@RequestBody ProfissionaisDTO profissionaisDTO) {
        ProfissionaisDTO criado = profissionaisService.criarProfissional(profissionaisDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Profissional " + criado.getNomeProfissional() + " de id " + criado.getId() + " criado com sucesso");
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Procura um profissional por ID", description = "Esta rota procura um profissional no banco de dados pelo ID")
    public ResponseEntity<?> listarProfissionalPorId(@PathVariable Long id) {
        ProfissionaisDTO profissional = profissionaisService.listarProfissionalPorId(id);
        if (profissional != null) {
            return ResponseEntity.ok(profissional);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
        }
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os profissionais", description = "Esta rota mostra todos os profissionais do banco de dados")
    public List<ProfissionaisDTO> listarProfissionais() {
        return profissionaisService.listarProfissionais();
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar dados do profissional", description = "Esta rota altera os dados de um profissional existente")
    public ResponseEntity<?> alterarProfissional(@PathVariable Long id, @RequestBody ProfissionaisDTO profissionaisDTO) {
        ProfissionaisDTO alterado = profissionaisService.atualizarProfissional(id, profissionaisDTO);
        if (alterado != null) {
            return ResponseEntity.ok(alterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar profissional", description = "Esta rota apaga um profissional presente no banco de dados")
    public ResponseEntity<String> deletarProfissional(@PathVariable Long id) {
        if (profissionaisService.listarProfissionalPorId(id) != null) {
            profissionaisService.deletarProfissional(id);
            return ResponseEntity.ok("Profissional " + id + " deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
        }
    }
}

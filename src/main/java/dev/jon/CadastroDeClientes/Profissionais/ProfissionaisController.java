package dev.jon.CadastroDeClientes.Profissionais;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissionais")
public class ProfissionaisController {

    // Envia requisição para mostrar profissionais
    @GetMapping("/listar")
    public String listarProfissional() {
        return "profissionais listados";
    }

    // Envia requisição para criar profissionais
    @PostMapping("/criar")
    public String criarProfissional() {
        return "profissional criado";
    }

    // Envia requisição para alterar profissionais
    @PutMapping("/alterar")
    public String alterarProfissional() {
        return "profissional alterado";
    }

    // Envia requisição para deletar profissionais
    @DeleteMapping("/deletar")
    public String deletarProfissional() {
        return "profissional deletado";
    }


}

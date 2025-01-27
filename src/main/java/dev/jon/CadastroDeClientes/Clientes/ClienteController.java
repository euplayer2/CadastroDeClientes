package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Teste mensagem na rota";
    }


    //adicionar cliente
    @PostMapping("/criar")
    public String criarCliente() {
        return "cliente criado";
    }

    //procurar cliente por id
    @GetMapping("/listarID")
    public String mostrarTodosOsClientesPorId() {
        return "listando por id";
    }

    //mostrar todos os clientes
    @GetMapping("/listar")
    public String mostrarTodosOsClientes() {
        return "listando todos os clientes";
    }

    //alterar dados clientes
    @PutMapping("/alterarID")
    public String mostrarClientesPorId() {
        return "alterar";
    }

    //deletar clientes
        @DeleteMapping("/deletarID")
        public String deletarClientePorId() {
            return "deletar";
        }

}

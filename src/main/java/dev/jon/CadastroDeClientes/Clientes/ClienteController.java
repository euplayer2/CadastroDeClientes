package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
    @GetMapping("/todosID")
    public String mostrarTodosOsClientesPorId() {
        return "mostrando por id";
    }

    //mostrar todos os clientes
    @GetMapping("/all")
    public String mostrarTodosOsClientes() {
        return "mostrando todos";
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

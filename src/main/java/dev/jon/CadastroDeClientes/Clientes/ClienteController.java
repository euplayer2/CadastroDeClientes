package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Teste mensagem na rota";
    }


    //adicionar cliente
    @PostMapping("/criar")
    public ClienteModel criarCliente( @RequestBody ClienteModel cliente) {
        return clienteService.criarCliente(cliente);
    }

    //procurar cliente por id
    @GetMapping("/listar/{id}")
    public ClienteModel listarClientesPorId(@PathVariable Long id) {
        return clienteService.listarClientesPorId(id);
    }

    //mostrar todos os clientes
    @GetMapping("/listar")
    public List<ClienteModel> listarClientes() {
        return clienteService.listarClientes();
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

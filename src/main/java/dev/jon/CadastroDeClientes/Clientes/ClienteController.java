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
    public ClienteDTO criarCliente( @RequestBody ClienteDTO clienteDTO) {
        return clienteService.criarCliente(clienteDTO);
    }

    //procurar cliente por id
    @GetMapping("/listar/{id}")
    public ClienteDTO listarClientesPorId(@PathVariable Long id) {
        return clienteService.listarClientesPorId(id);
    }

    //mostrar todos os clientes
    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    //alterar dados clientes
    @PutMapping("/alterar/{id}")
    public ClienteDTO alterarCliente (@PathVariable Long id, @RequestBody ClienteDTO clienteAtualizado) {
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }

    //deletar clientes
        @DeleteMapping("/deletar/{id}")
        public void deletarCliente(@PathVariable Long id) {
            clienteService.deletarCliente(id);
        }

}

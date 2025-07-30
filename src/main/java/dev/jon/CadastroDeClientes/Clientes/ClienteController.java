package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <String> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " + clienteCriado.getNome() + " de id " + clienteCriado.getId() + " criado com sucesso");
    }

    //procurar cliente por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarClientesPorId(@PathVariable Long id) {
        ClienteDTO cliente =  clienteService.listarClientesPorId(id);
        if (cliente != null) {
           return ResponseEntity.ok(cliente);
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    //mostrar todos os clientes
    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    //alterar dados clientes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCliente (@PathVariable Long id, @RequestBody ClienteDTO clienteAtualizado) {
        ClienteDTO clienteAlterado = clienteService.atualizarCliente(id, clienteAtualizado);
        if (clienteAlterado != null) {
           return ResponseEntity.ok(clienteAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    //deletar clientes
        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        if (clienteService.listarClientesPorId(id) != null) {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente " + id + " deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        }

}

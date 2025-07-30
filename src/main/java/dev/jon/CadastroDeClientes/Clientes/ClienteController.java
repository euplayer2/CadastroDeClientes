package dev.jon.CadastroDeClientes.Clientes;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation (summary = "Mensagem teste", description = "Testa rapidamente se o controller esta funcionando corretamente")
    public String boasVindas() {
        return "Teste mensagem na rota";
    }


    //adicionar cliente
    @PostMapping("/criar")
    @Operation (summary = "Cria um cliente", description = "Esta rota cria um novo cliente e insere no banco de dados")
    public ResponseEntity <String> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " + clienteCriado.getNome() + " de id " + clienteCriado.getId() + " criado com sucesso");
    }

    //procurar cliente por id
    @GetMapping("/listar/{id}")
    @Operation (summary = "Procura um cliente por ID", description = "Esta rota procura um cliente no banco de dados pelo ID dele")
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
    @Operation (summary = "Mostra todos os clientes", description = "Esta rota lista todos os clientes presentes no banco de dados")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    //alterar dados clientes
    @PutMapping("/alterar/{id}")
    @Operation (summary = "Alterar dados do cliente", description = "Esta rota altera dados de um cliente")
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
        @Operation (summary = "Deletar cliente", description = "Esta rota apaga um cliente presente no banco de dados")
        public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        if (clienteService.listarClientesPorId(id) != null) {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente " + id + " deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        }

}

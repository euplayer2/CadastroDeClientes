package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //listar todos os clientes
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    //listar clientes por ID
    public ClienteModel listarClientesPorId(Long id) {
        Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
        return clientePorId.orElse(null);
    }

    //criar cliente
    public ClienteModel criarCliente (ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    //apagar cliente
    public void deletarCliente (Long id) {
        clienteRepository.deleteById(id);
            }

    //atualizar cliente
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }



}

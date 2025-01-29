package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;

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

}

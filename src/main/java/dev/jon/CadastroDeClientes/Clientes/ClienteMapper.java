package dev.jon.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO) {

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setTelefone(clienteDTO.getTelefone());
        clienteModel.setProfissionais(clienteDTO.getProfissionais());
        clienteModel.setEmail(clienteDTO.getEmail());

        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel) {

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setTelefone(clienteModel.getTelefone());
        clienteDTO.setProfissionais(clienteModel.getProfissionais());
        clienteDTO.setEmail(clienteModel.getEmail());

        return clienteDTO;

    }

}

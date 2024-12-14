package dev.jon.CadastroDeClientes.Profissionais;

import dev.jon.CadastroDeClientes.Clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_profissionais")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfissionaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProfissional;
    private ClienteModel cliente;

    @OneToMany(mappedBy = "profissionais")
    private List<ClienteModel> clientes;

}

package dev.jon.CadastroDeClientes.Profissionais;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.jon.CadastroDeClientes.Clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_profissionais")
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_profissional", nullable = false)
    private String nomeProfissional;

    //Um profissional para vários clientes
    @OneToMany(mappedBy = "profissionais")
    @JsonIgnore
    private List<ClienteModel> clientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public List<ClienteModel> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteModel> clientes) {
        this.clientes = clientes;
    }
}
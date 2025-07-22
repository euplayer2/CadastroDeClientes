package dev.jon.CadastroDeClientes.Clientes;

import dev.jon.CadastroDeClientes.Profissionais.ProfissionaisModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private ProfissionaisModel profissionais;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ProfissionaisModel getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(ProfissionaisModel profissionais) {
        this.profissionais = profissionais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

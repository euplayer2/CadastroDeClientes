package dev.jon.CadastroDeClientes.Clientes;

import dev.jon.CadastroDeClientes.Profissionais.ProfissionaisModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_cliente")
    private String nome;
    @Column(unique = true)
    private String telefone;
    @Column(name = "email")
    private String email;

    // um cliente por profissional
    @ManyToOne
    @JoinColumn(name = "profissionais_id")
    private ProfissionaisModel profissionais;

// lombok bugou
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfissionaisModel getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(ProfissionaisModel profissionais) {
        this.profissionais = profissionais;
    }
}
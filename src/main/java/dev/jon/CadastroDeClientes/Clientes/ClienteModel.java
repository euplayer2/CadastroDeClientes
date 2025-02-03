package dev.jon.CadastroDeClientes.Clientes;

import dev.jon.CadastroDeClientes.Profissionais.ProfissionaisModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
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

    // um cliente por profissional
    @ManyToOne
    @JoinColumn(name = "profissionais_id")
    private ProfissionaisModel profissionais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfissionaisModel getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(ProfissionaisModel profissionais) {
        this.profissionais = profissionais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
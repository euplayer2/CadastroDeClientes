package dev.jon.CadastroDeClientes.Clientes;

import dev.jon.CadastroDeClientes.Profissionais.ProfissionaisModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}

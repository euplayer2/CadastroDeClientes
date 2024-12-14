package dev.jon.CadastroDeClientes.Clientes;

import dev.jon.CadastroDeClientes.Profissionais.ProfissionaisModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_-cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;

    // um cliente por profissional
    @ManyToOne
    @JoinColumn(name = "profissionais_id")
    private ProfissionaisModel profissionais;

}

package dev.jon.CadastroDeClientes.Profissionais;

import org.springframework.stereotype.Component;

@Component
public class ProfissionaisMapper {

    public ProfissionaisModel map(ProfissionaisDTO dto) {
        ProfissionaisModel model = new ProfissionaisModel();
        model.setId(dto.getId());
        model.setNomeProfissional(dto.getNomeProfissional());
        model.setClientes(dto.getClientes());
        return model;
    }

    public ProfissionaisDTO map(ProfissionaisModel model) {
        ProfissionaisDTO dto = new ProfissionaisDTO();
        dto.setId(model.getId());
        dto.setNomeProfissional(model.getNomeProfissional());
        dto.setClientes(model.getClientes());
        return dto;
    }
}

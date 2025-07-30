package dev.jon.CadastroDeClientes.Profissionais;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionaisService {

    private final ProfissionaisRepository profissionaisRepository;
    private final ProfissionaisMapper profissionaisMapper;

    public ProfissionaisService(ProfissionaisRepository profissionaisRepository, ProfissionaisMapper profissionaisMapper) {
        this.profissionaisRepository = profissionaisRepository;
        this.profissionaisMapper = profissionaisMapper;
    }

    public List<ProfissionaisDTO> listarProfissionais() {
        List<ProfissionaisModel> profissionais = profissionaisRepository.findAll();
        return profissionais.stream()
                .map(profissionaisMapper::map)
                .collect(Collectors.toList());
    }

    public ProfissionaisDTO listarProfissionalPorId(Long id) {
        Optional<ProfissionaisModel> profissional = profissionaisRepository.findById(id);
        return profissional.map(profissionaisMapper::map).orElse(null);
    }

    public ProfissionaisDTO criarProfissional(ProfissionaisDTO profissionaisDTO) {
        ProfissionaisModel profissional = profissionaisMapper.map(profissionaisDTO);
        profissional = profissionaisRepository.save(profissional);
        return profissionaisMapper.map(profissional);
    }

    public void deletarProfissional(Long id) {
        profissionaisRepository.deleteById(id);
    }

    public ProfissionaisDTO atualizarProfissional(Long id, ProfissionaisDTO profissionaisDTO) {
        Optional<ProfissionaisModel> profissionalExistente = profissionaisRepository.findById(id);
        if (profissionalExistente.isPresent()) {
            ProfissionaisModel atualizado = profissionaisMapper.map(profissionaisDTO);
            atualizado.setId(id);
            ProfissionaisModel salvo = profissionaisRepository.save(atualizado);
            return profissionaisMapper.map(salvo);
        }
        return null;
    }
}

package br.com.apisenai.service;

import br.com.apisenai.Repository.RegistroRepository;
import br.com.apisenai.domain.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    RegistroRepository registroRepository;

    public Registro criarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    public Optional<Registro> findById(Long id) {
        return registroRepository.findById(id);
    }

    public List<Registro> findByName(String nome) {
        return registroRepository.findRegistrosByNomeIgnoreCase(nome);
    }

    public void deleteRegistro(Long id) {
        registroRepository.deleteById(id);
    }

    public void atualizarRegistroEmail(String nome, Long id) {
        registroRepository.atualizaEmail(nome, id);
    }

    public void atualizarRegistro(Registro registro, Long id) {
        registro.setId(id);
        registroRepository.save(registro);
    }

}

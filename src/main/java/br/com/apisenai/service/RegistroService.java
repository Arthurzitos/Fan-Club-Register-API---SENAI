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

    public void atualizarRegistroEmail(String email, Long id) {
        registroRepository.atualizaEmail(email, id);
    }

    public void atualizarRegistroNome(String nome, Long id) {
        registroRepository.atualizaNome(nome, id);
    }

    public void atualizarRegistroSobreNome(String sobrenome, Long id) {
        registroRepository.atualizaSobreNome(sobrenome, id);
    }
    
    public void atualizarRegistroApelido(String sobrenome, Long id) {
        registroRepository.atualizaSobreNome(sobrenome, id);
    }
    
    public void atualizarRegistroSenha(String senha, Long id) {
        registroRepository.atualizaSenha(senha, id);
    }

    public void atualizarRegistro(Registro registro, Long id) {
        registro.setId(id);
        registroRepository.save(registro);
    }

    

}

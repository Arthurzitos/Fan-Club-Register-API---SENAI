package br.com.apisenai.service;

import br.com.apisenai.Repository.UserRegistrationRepository;
import br.com.apisenai.domain.entity.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    public UserRegistration criarRegistro(UserRegistration userRegistration) {
        return userRegistrationRepository.save(userRegistration);
    }

    public List<UserRegistration> findAll() {
        return userRegistrationRepository.findAll();
    }

    public Optional<UserRegistration> findById(Long id) {
        return userRegistrationRepository.findById(id);
    }

    public List<UserRegistration> findByName(String nome) {
        return userRegistrationRepository.findRegistrosByNomeIgnoreCase(nome);
    }

    public void deleteRegistro(Long id) {
        userRegistrationRepository.deleteById(id);
    }

    public void atualizarRegistroEmail(String email, Long id) {
        userRegistrationRepository.atualizaEmail(email, id);
    }

    public void atualizarRegistroSenha(String senha, Long id) {
        userRegistrationRepository.atualizaSenha(senha, id);
    }

    public void atualizarRegistroNome(String nome, Long id) {
        userRegistrationRepository.atualizaNome(nome, id);
    }

    public void atualizarRegistroSobreNome(String sobrenome, Long id) {
        userRegistrationRepository.atualizaSobreNome(sobrenome, id);
    }

    public void atualizarRegistroApelido(String apelido, Long id) {
        userRegistrationRepository.atualizaApelido(apelido, id);
    }
    

    public void atualizarRegistro(UserRegistration userRegistration, Long id) {
        userRegistration.setId(id);
        userRegistrationRepository.save(userRegistration);
    }
}

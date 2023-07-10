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

    public UserRegistration createRegister(UserRegistration userRegistration) {
        return userRegistrationRepository.save(userRegistration);
    }

    public List<UserRegistration> findAll() {
        return userRegistrationRepository.findAll();
    }

    public Optional<UserRegistration> findById(Long id) {
        return userRegistrationRepository.findById(id);
    }

    public List<UserRegistration> findByName(String nome) {
        return userRegistrationRepository.findRegistersByNameIgnoreCase(nome);
    }

    public void deleteRegister(Long id) {
        userRegistrationRepository.deleteById(id);
    }

    public void updateRegisterEmail(String email, Long id) {
        userRegistrationRepository.updateEmail(email, id);
    }

    public void updateRegisterPassword(String password, Long id) {
        userRegistrationRepository.updatePassword(password, id);
    }

    public void updateRegisterName(String name, Long id) {
        userRegistrationRepository.updateName(name, id);
    }

    public void updateRegisterSurname(String surname, Long id) {
        userRegistrationRepository.updateSurname(surname, id);
    }

    public void updateRegisterNickname(String nickname, Long id) {
        userRegistrationRepository.updateNickname(nickname, id);
    }
    

    public void updateRegister(UserRegistration userRegistration, Long id) {
        userRegistration.setId(id);
        userRegistrationRepository.save(userRegistration);
    }
}

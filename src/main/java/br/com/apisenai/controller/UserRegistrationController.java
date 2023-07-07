package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.UserRegistration;
import br.com.apisenai.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/userRegister")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping("/createRegister/")
    public ResponseEntity<String> newRegister(@RequestBody UserRegistration userRegistration) {
        try {
            userRegistrationService.createRegister(userRegistration);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/listRegister")
    public List<UserRegistration> findAll() {
        return userRegistrationService.findAll();
    }

    @GetMapping("/findById/{id}")
    public UserRegistration findById(@PathVariable Long id) {
        return userRegistrationService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findByName/{name}")
    public List<UserRegistration> findByName(@PathVariable String nome) {
        return userRegistrationService.findByName(nome);
    }

    @PatchMapping("/updateEmail/{id}/{email}")
    public ResponseEntity<String> updateRegisterEmail(@PathVariable String email, @PathVariable Long id){
        try {
            userRegistrationService.updateRegisterEmail(email, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar e-mail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("E-mail atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updatePassword/{id}/{password}")
    public ResponseEntity<String> updateRegisterPassword(@PathVariable String password, @PathVariable Long id){
        try {
            userRegistrationService.updateRegisterPassword(password, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar senha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Senha atualizada com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateName/{id}/{name}")
    public ResponseEntity<String> updateRegisterName(@PathVariable String name, @PathVariable Long id){
        try {
            userRegistrationService.updateRegisterName(name, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateSurname/{id}/{surname}")
    public ResponseEntity<String> updateRegisterSurname(@PathVariable String surname, @PathVariable Long id){
        try {
            userRegistrationService.updateRegisterSurname(surname, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar sobrenome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sobrenome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateNickname/{id}/{nickname}")
    public ResponseEntity<String> updateRegisterNickname(@PathVariable String nickname, @PathVariable Long id){
        try {
            userRegistrationService.updateRegisterNickname(nickname, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar apelido", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Apelido atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/updateRegister/{id}")
    public ResponseEntity<String> update(@RequestBody UserRegistration userRegistration, @PathVariable Long id){
        try {
            userRegistrationService.updateRegister(userRegistration, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar registro", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registro atualizado com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userRegistrationService.deleteRegister(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário excluído com sucesso!", HttpStatus.CREATED);
    }
}

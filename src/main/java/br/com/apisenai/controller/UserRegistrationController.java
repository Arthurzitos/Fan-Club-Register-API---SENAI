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
    public ResponseEntity<String> novoRegistro(@RequestBody UserRegistration userRegistration) {
        try {
            userRegistrationService.criarRegistro(userRegistration);
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

    @GetMapping("/findByName/{nome}")
    public List<UserRegistration> findByName(@PathVariable String nome) {
        return userRegistrationService.findByName(nome);
    }

    @PatchMapping("/updateEmail/{id}/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable String email, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistroEmail(email, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar e-mail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("E-mail atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateSenha/{id}/{senha}")
    public ResponseEntity<String> updateSenha(@PathVariable String senha, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistroSenha(senha, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar senha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Senha atualizada com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateNome/{id}/{nome}")
    public ResponseEntity<String> updateNome(@PathVariable String nome, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistroNome(nome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateSobreNome/{id}/{sobrenome}")
    public ResponseEntity<String> updateSobreNome(@PathVariable String sobrenome, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistroSobreNome(sobrenome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar sobrenome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sobrenome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateApelido/{id}/{apelido}")
    public ResponseEntity<String> updateApelido(@PathVariable String apelido, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistroApelido(apelido, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar apelido", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Apelido atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/updateRegister/{id}")
    public ResponseEntity<String> update(@RequestBody UserRegistration userRegistration, @PathVariable Long id){
        try {
            userRegistrationService.atualizarRegistro(userRegistration, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar registro", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registro atualizado com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userRegistrationService.deleteRegistro(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário excluído com sucesso!", HttpStatus.CREATED);
    }
}

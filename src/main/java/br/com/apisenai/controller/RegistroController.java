package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.Registro;
import br.com.apisenai.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    RegistroService registroService;

<<<<<<< HEAD
    @PostMapping("/createRegister/")
    public ResponseEntity<String> novoRegistro(@RequestBody Registro registro) {
        try {
            registroService.criarRegistro(registro);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
=======
    @PostMapping("/createRegister")
    public Registro novoRegistro(@RequestBody Registro registro) {
        return registroService.criarRegistro(registro);
>>>>>>> a0004fbeea443ccfce002496f600bb8a4723f137
    }

    @GetMapping("/listRegister")
    public List<Registro> findAll() {
        return registroService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Registro findById(@PathVariable Long id) {
        return registroService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findByName/{nome}")
    public List<Registro> findByName(@PathVariable String nome) {
        return registroService.findByName(nome);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            registroService.deleteRegistro(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário excluído com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateEmail/{id}/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable String email, @PathVariable Long id){
        try {
            registroService.atualizarRegistroEmail(email, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar e-mail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("E-mail atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateSenha/{id}/{senha}")
    public void updateSenha(@PathVariable String senha, @PathVariable Long id){
        registroService.atualizarRegistroSenha(senha, id);
    }

    @PatchMapping("/updateNome/{id}/{nome}")
    public ResponseEntity<String> updateNome(@PathVariable String nome, @PathVariable Long id){
        try {
            registroService.atualizarRegistroNome(nome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateSobreNome/{id}/{sobrenome}")
    public ResponseEntity<String> updateSobreNome(@PathVariable String sobrenome, @PathVariable Long id){
        try {
            registroService.atualizarRegistroSobreNome(sobrenome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar sobrenome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sobrenome atualizado com sucesso!", HttpStatus.CREATED);
    }
    
    @PatchMapping("/updateApelido/{id}/{apelido}")
    public ResponseEntity<String> updateApelido(@PathVariable String apelido, @PathVariable Long id){
        try {
            registroService.atualizarRegistroApelido(apelido, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar apelido", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Apelido atualizado com sucesso!", HttpStatus.CREATED);
    }
    
<<<<<<< HEAD
    @PatchMapping("/updateSenha/{id}/{senha}")
    public ResponseEntity<String> updateSenha(@PathVariable String senha, @PathVariable Long id){
        try {
            registroService.atualizarRegistroSenha(senha, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar senha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Senha atualizada com sucesso!", HttpStatus.CREATED);
    }
=======
>>>>>>> a0004fbeea443ccfce002496f600bb8a4723f137

    @PutMapping("/updateRegister/{id}")
    public ResponseEntity<String> update(@RequestBody Registro registro, @PathVariable Long id){
        try {
            registroService.atualizarRegistro(registro, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar registro", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registro atualizado com sucesso!", HttpStatus.CREATED);
    }

}

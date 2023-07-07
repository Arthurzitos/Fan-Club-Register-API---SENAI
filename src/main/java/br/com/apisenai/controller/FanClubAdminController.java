package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.FanClubAdmin;
import br.com.apisenai.service.FanClubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class FanClubAdminController {

    @Autowired
    FanClubAdminService fanClubAdminService;

    @PostMapping("/createFanClubAdmin/")
    public ResponseEntity<String> novoFanClubAdmin(@RequestBody FanClubAdmin fanClubAdmin) {
        try {
            fanClubAdminService.criarFanClubAdmin(fanClubAdmin);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar admin", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Admin cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/listFanClubAdmin")
    public List<FanClubAdmin> findAll() {
        return fanClubAdminService.findAll();
    }

    @GetMapping("/findFanClubAdminById/{id}")
    public FanClubAdmin findById(@PathVariable Long id) {
        return fanClubAdminService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findFanClubAdminByName/{nome}")
    public List<FanClubAdmin> findByName(@PathVariable String nome) {
        return fanClubAdminService.findByName(nome);
    }

    @PatchMapping("/updateFanClubAdminEmail/{id}/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable String email, @PathVariable Long id){
        try {
            fanClubAdminService.atualizarFanClubAdminEmail(email, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar e-mail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("E-mail atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminSenha/{id}/{senha}")
    public ResponseEntity<String> updateSenha(@PathVariable String senha, @PathVariable Long id){
        try {
            fanClubAdminService.atualizarFanClubAdminSenha(senha, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar senha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Senha atualizada com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminNome/{id}/{nome}")
    public ResponseEntity<String> updateNome(@PathVariable String nome, @PathVariable Long id){
        try {
            fanClubAdminService.atualizarFanClubAdminNome(nome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminSobrenome/{id}/{sobrenome}")
    public ResponseEntity<String> updateSobreNome(@PathVariable String sobrenome, @PathVariable Long id){
        try {
            fanClubAdminService.atualizarFanClubAdminSobreNome(sobrenome, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar sobrenome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sobrenome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/updateFanClubAdmin/{id}")
    public ResponseEntity<String> update(@RequestBody FanClubAdmin fanClubAdmin, @PathVariable Long id){
        try {
            fanClubAdminService.atualizarFanClubAdmin(fanClubAdmin, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar admin", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Admin atualizado com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteFanClubAdmin/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            fanClubAdminService.deleteFanClubAdmin(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir admin", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Admin excluído com sucesso!", HttpStatus.CREATED);
    }
}

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

    @PostMapping("/createFanClubAdmin")
    public ResponseEntity<String> newFanClubAdmin(@RequestBody FanClubAdmin fanClubAdmin) {
        try {
            fanClubAdminService.createFanClubAdmin(fanClubAdmin);
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

    @GetMapping("/findFanClubAdminByName/{name}")
    public List<FanClubAdmin> findByName(@PathVariable String name) {
        return fanClubAdminService.findByName(name);
    }

    @PatchMapping("/updateFanClubAdminEmail/{id}/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable String email, @PathVariable Long id){
        try {
            fanClubAdminService.updateFanClubAdminEmail(email, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar e-mail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("E-mail atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminSenha/{id}/{password}")
    public ResponseEntity<String> updatePassword(@PathVariable String password, @PathVariable Long id){
        try {
            fanClubAdminService.updateFanClubAdminPassword(password, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar senha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Senha atualizada com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminName/{id}/{name}")
    public ResponseEntity<String> updateName(@PathVariable String name, @PathVariable Long id){
        try {
            fanClubAdminService.updateFanClubAdminName(name, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateFanClubAdminSurname/{id}/{surname}")
    public ResponseEntity<String> updateSurname(@PathVariable String surname, @PathVariable Long id){
        try {
            fanClubAdminService.updateFanClubAdminSurname(surname, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar sobrenome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Sobrenome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/updateFanClubAdmin/{id}")
    public ResponseEntity<String> update(@RequestBody FanClubAdmin fanClubAdmin, @PathVariable Long id){
        try {
            fanClubAdminService.updateFanClubAdmin(fanClubAdmin, id);
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

package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.FanClub;
import br.com.apisenai.service.FanClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/fanClub")
public class FanClubController {

    @Autowired
    FanClubService fanClubService;

    @PostMapping("/createFanClub/")
    public ResponseEntity<String> createFanClub(@RequestBody FanClub fanClub) {
        try {
            fanClubService.createFanClub(fanClub);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar usuário", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/listFanClub")
    public List<FanClub> findAll() {
        return fanClubService.findAll();
    }

    @GetMapping("/findFanClubById/{id}")
    public FanClub findFanClubById(@PathVariable Long id) {
        return fanClubService.findFanClubById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findFanClubByName/{name}")
    public List<FanClub> findFanClubByName(@PathVariable String name) {
        return fanClubService.findFanClubByName(name);
    }

    @PatchMapping("/updateName/{id}/{name}")
    public ResponseEntity<String> updateName(@PathVariable String name, @PathVariable Long id){
        try {
            fanClubService.updateName(name, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateDescription/{id}/{description}")
    public ResponseEntity<String> updateDescription(@PathVariable String description, @PathVariable Long id){
        try {
            fanClubService.updateDescription(description, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar descricao", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Descricao atualizada com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteFanClub/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            fanClubService.deleteFanClub(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir fa clube", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Fa clube excluído com sucesso!", HttpStatus.CREATED);
    }
}

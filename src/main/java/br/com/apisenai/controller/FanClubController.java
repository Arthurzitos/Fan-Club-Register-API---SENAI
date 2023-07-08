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

    @GetMapping("/findFanClubByName/{fanClubName}")
    public List<FanClub> findFanClubByName(@PathVariable String fanClubName) {
        return fanClubService.findByFanClubName(fanClubName);
    }

    @PatchMapping("/updateName/{id}/{fanClubName}")
    public ResponseEntity<String> updatefanClubName(@PathVariable String fanClubName, @PathVariable Long id){
        try {
            fanClubService.updateFanClubName(fanClubName, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar nome do fa clube", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Nome do fa clube atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateDescription/{id}/{fanClubDescription}")
    public ResponseEntity<String> updatefanClubDescription(@PathVariable String fanClubDescription, @PathVariable Long id){
        try {
            fanClubService.updateFanClubDescription(fanClubDescription, id);
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

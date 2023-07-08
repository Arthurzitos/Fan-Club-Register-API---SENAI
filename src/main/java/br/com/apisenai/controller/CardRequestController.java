package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.CardRequest;
import br.com.apisenai.service.CardRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cardRequest")
public class CardRequestController {

    @Autowired
    CardRequestService cardRequestService;

    @GetMapping("/findCardRequestById/{id}")
    public List<CardRequest> findByName(@PathVariable Long id) {
        return cardRequestService.findCardRequestById(id);
    }

    @GetMapping("/listCardRequest")
    public List<CardRequest> findAll() {
        return cardRequestService.findAll();
    }
    @PatchMapping("/setCardStatus/{id}/{cardStatus}")
    public ResponseEntity<String> setCardStatus(@PathVariable Long id, @PathVariable CardRequest.CardStatus cardStatus) {
        try {
            cardRequestService.setCardStatus(id, cardStatus);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao definir o status da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Status da carteirinha definido com sucesso!", HttpStatus.OK);
    }

    @PatchMapping("/updateCardStatus/{id}/{cardStatus}")
    public ResponseEntity<String> updateRegisterPassword(@PathVariable CardRequest.CardStatus cardStatus, @PathVariable Long id){
        try {
            cardRequestService.updateCardStatus(cardStatus, id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar o status da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Status da carteirinha atualizado com sucesso!", HttpStatus.OK);
    }
}

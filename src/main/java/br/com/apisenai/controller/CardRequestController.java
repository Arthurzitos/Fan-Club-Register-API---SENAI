package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.CardRequest;
import br.com.apisenai.service.CardRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cardRequest")
public class CardRequestController {

    @Autowired
    CardRequestService cardRequestService;

    @PatchMapping("/setCardStatus/{id}/{cardStatus}")
    public ResponseEntity<String> setCardStatus(@PathVariable Long id, @PathVariable CardRequest.CardStatus cardStatus) {
        try {
            cardRequestService.findCardRequestById(id);
            cardRequestService.setCardStatus(id, cardStatus);
            cardRequestService.updateCardStatus(cardStatus, id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar o status da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Status da carteirinha atualizado com sucesso!", HttpStatus.OK);
    } //conferir se ta certo ou se tem q criar um unico so de update
}

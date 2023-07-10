package br.com.apisenai.controller;

import br.com.apisenai.Repository.UserRegistrationRepository;
import br.com.apisenai.domain.entity.CardRequest;
import br.com.apisenai.domain.entity.UserRegistration;
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

    @PatchMapping("/updateCardStatus/{id}/{cardStatus}")
    public ResponseEntity<String> updateRegisterPassword(@PathVariable CardRequest.CardStatus cardStatus, @PathVariable Long id){
        try {
            cardRequestService.updateCardStatus(cardStatus, id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar o status da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Status da carteirinha atualizado com sucesso!", HttpStatus.OK);
    }

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    @PostMapping("/createCardRequest")
    public ResponseEntity<String> createCardRequest(
            @RequestParam Long userId,
            @RequestParam CardRequest.CardStatus cardStatus
    ) {
        UserRegistration user = userRegistrationRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        try {
            cardRequestService.createCardRequest(user, cardStatus);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create card request", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Card request created successfully!", HttpStatus.OK);
    }
}

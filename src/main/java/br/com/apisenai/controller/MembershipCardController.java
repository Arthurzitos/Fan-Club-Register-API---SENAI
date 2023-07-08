package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.MembershipCard;
import br.com.apisenai.service.MembershipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/MembershipCard")
public class MembershipCardController {

    @Autowired
    MembershipCardService membershipCardService;

    @GetMapping("/listMembershipCard")
    public List<MembershipCard> findAll() {
        return membershipCardService.findAll();
    }

    @PostMapping("/createMembershipCard/")
    public ResponseEntity<String> createMembershipCard(@RequestBody MembershipCard membershipCard) {
        try {
            membershipCardService.createMembershipCard(membershipCard);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Carteirinha cadastrada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/findCardById/{id}")
    public MembershipCard findCardById(@PathVariable Long id) {
        return membershipCardService.findCardById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findCardByCardNumber/{cardNumber}")
    public List<MembershipCard> findCardByNumber(@PathVariable String cardNumber) {
        return membershipCardService.findCardByCardNumber(cardNumber);
    }

    @PatchMapping("/updateMembershipCardNumber/{id}/{cardNumber}")
    public ResponseEntity<String> updateMembershipCardNumber(@PathVariable String cardNumber, @PathVariable Long id){
        try {
            membershipCardService.updateMembershipCardNumber(cardNumber, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar numero da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Numero da carteirinha atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateMembershipCardPhotoUrl/{id}/{photoUrl}")
    public ResponseEntity<String> updateMembershipCardPhotoUrl(@PathVariable String photoUrl, @PathVariable Long id){
        try {
            membershipCardService.updateMembershipCardPhotoUrl(photoUrl, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar foto da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Foto da carteirinha atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updateMembershipCardActivation/{id}/{isActive}")
    public ResponseEntity<String> updateMembershipCardActivation(@PathVariable boolean isActive, @PathVariable Long id){
        try {
            membershipCardService.updateMembershipCardActivation(isActive, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar status de ativacao da carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Status de ativacao da carteirinha atualizada com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMembershipCardById/{id}")
    public ResponseEntity<String> deleteMembershipCardById(@PathVariable Long id) {
        try {
            membershipCardService.deleteMembershipCardById(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir carteirinha", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Carteirinha excluída com sucesso!", HttpStatus.CREATED);
    }
}

package br.com.apisenai.service;

import br.com.apisenai.Repository.MembershipCardRepository;
import br.com.apisenai.domain.entity.CardRequest;
import br.com.apisenai.domain.entity.MembershipCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MembershipCardService {

    @Autowired
    MembershipCardRepository membershipCardRepository;

    public MembershipCard createMembershipCard(MembershipCard membershipCard) {
        return membershipCardRepository.save(membershipCard);
    }

    public void deleteMembershipCardById(Long id) {

        membershipCardRepository.deleteById(id);
    }

    public void updateMembershipCardNumber(String cardNumber, Long id) {
        membershipCardRepository.updateMembershipCardNumber(cardNumber, id);
    }

    public void updateMembershipCardPhotoUrl(String photoUrl, Long id) {
        membershipCardRepository.updateMembershipCardPhotoUrl(photoUrl, id);
    }

    public void updateMembershipCardStatus(CardRequest.CardStatus cardStatus, Long id) {
        membershipCardRepository.updateMembershipCardStatus(cardStatus, id);
    }

    public List<MembershipCard> findAll() {

        return membershipCardRepository.findAll();
    }

    public Optional<MembershipCard> findCardById(Long id) {
        return membershipCardRepository.findById(id);
    }

    public List<MembershipCard> findCardByCardNumber(String cardNumber) {
        return membershipCardRepository.findCardByCardNumber(cardNumber);
    }
}

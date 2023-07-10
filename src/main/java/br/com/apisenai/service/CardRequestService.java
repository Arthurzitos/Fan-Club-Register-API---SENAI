package br.com.apisenai.service;

import br.com.apisenai.Repository.CardRequestRepository;
import br.com.apisenai.domain.entity.CardRequest;
import br.com.apisenai.domain.entity.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardRequestService {

    @Autowired
    CardRequestRepository cardRequestRepository;

    public CardRequest createCardRequest(UserRegistration user, CardRequest.CardStatus cardStatus) {
        CardRequest cardRequest = CardRequest.builder()
                .user(user)
                .requestDate(LocalDate.now())
                .cardStatus(cardStatus)
                .build();

        return cardRequestRepository.save(cardRequest);
    }
    public List<CardRequest> findAll() {
        return cardRequestRepository.findAll();
    }

    public void updateCardStatus(CardRequest.CardStatus cardStatus, Long id) {
        cardRequestRepository.updateCardStatus(cardStatus, id);
    }
    public List<CardRequest> findCardRequestById(Long id) {
        return cardRequestRepository.findCardRequestById(id);
    }
}

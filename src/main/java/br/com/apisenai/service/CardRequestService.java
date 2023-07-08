package br.com.apisenai.service;

import br.com.apisenai.Repository.CardRequestRepository;
import br.com.apisenai.domain.entity.CardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardRequestService {

    @Autowired
    CardRequestRepository cardRequestRepository;
    public void setCardStatus(Long id, CardRequest.CardStatus cardStatus) {
        CardRequest cardRequest = cardRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma carteirinha com id: " + id + " foi encontrada."));

        cardRequest.setCardStatus(cardStatus);
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

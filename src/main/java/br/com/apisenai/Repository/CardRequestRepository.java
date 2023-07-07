package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.CardRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CardRequestRepository extends JpaRepository<CardRequest, Long> {
    @Transactional
    @Modifying
    @Query("update CardRequest r set r.cardStatus = ?1 where r.id = ?2")
    void updateCardStatus(CardRequest.CardStatus cardStatus, Long id);

    List<CardRequest> findCardRequestById(Long id);
}

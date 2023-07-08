package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.MembershipCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {
    @Transactional
    @Modifying
    @Query("update MembershipCard r set r.photoUrl = ?1 where r.id = ?2")
    void updateMembershipCardPhotoUrl(String photoUrl, Long Id);

    @Transactional
    @Modifying
    @Query("update MembershipCard r set r.cardNumber = ?1 where r.id = ?2")
    void updateMembershipCardNumber(String cardNumber, Long Id);

    @Transactional
    @Modifying
    @Query("update MembershipCard r set r.isActive = ?1 where r.id = ?2")
    boolean updateMembershipCardActivation(boolean isActive, Long Id);

    List<MembershipCard> findCardByCardNumber(String cardNumber);
}

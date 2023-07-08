package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.FanClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FanClubRepository extends JpaRepository<FanClub, Long> {
    @Transactional
    @Modifying
    @Query("update FanClub r set r.fanClubName = ?1 where r.id = ?2")
    void updateFanClubName(String fanClubName, Long Id);

    @Transactional
    @Modifying
    @Query("update FanClub r set r.fanClubDescription = ?1 where r.id = ?2")
    void updateFanClubDescription(String fanClubDescription, Long Id);

    List<FanClub> findByFanClubName(String fanClubName);
}

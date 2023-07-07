package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.FanClubAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FanClubAdminRepository extends JpaRepository<FanClubAdmin, Long> {
    @Transactional
    @Modifying
    @Query("update FanClubAdmin r set r.email = ?1 where r.id = ?2")
    void updateEmail(String email, Long Id);

    @Transactional
    @Modifying
    @Query("update FanClubAdmin r set r.password = ?1 where r.id = ?2")
    void updatePassword(String password, Long Id);

    @Transactional
    @Modifying
    @Query("update FanClubAdmin r set r.name = ?1 where r.id = ?2")
    void updateName(String name, Long Id);

    @Transactional
    @Modifying
    @Query("update FanClubAdmin r set r.surname = ?1 where r.id = ?2")
    void updateSurname(String surname, Long Id);

    List<FanClubAdmin> findFanClubAdminsByName(String name);
}

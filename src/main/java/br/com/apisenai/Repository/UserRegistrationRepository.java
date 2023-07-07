package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.email = ?1 where r.id = ?2")
    void updateEmail(String email, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.password = ?1 where r.id = ?2")
    void updatePassword(String password, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.name = ?1 where r.id = ?2")
    void updateName(String name, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.surname = ?1 where r.id = ?2")
    void updateSurname(String surname, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.nickname = ?1 where r.id = ?2")
    void updateNickname(String nickname, Long id);

    List<UserRegistration> findRegistrosByNameIgnoreCase(String name);
}

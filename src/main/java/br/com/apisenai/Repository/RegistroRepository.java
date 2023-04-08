package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    @Transactional
    @Modifying
    @Query("update Registro r set r.email = ?1 where r.id = ?2")
    void atualizaEmail(String email, Long Id);

    List<Registro> findRegistrosByNomeIgnoreCase(String nome);
}

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
    void atualizaEmail(String email, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.senha = ?1 where r.id = ?2")
    void atualizaSenha(String senha, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.nome = ?1 where r.id = ?2")
    void atualizaNome(String nome, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.sobrenome = ?1 where r.id = ?2")
    void atualizaSobreNome(String sobrenome, Long id);

    @Transactional
    @Modifying
    @Query("update UserRegistration r set r.apelido = ?1 where r.id = ?2")
    void atualizaApelido(String apelido, Long id);

    List<UserRegistration> findRegistrosByNomeIgnoreCase(String nome);
}

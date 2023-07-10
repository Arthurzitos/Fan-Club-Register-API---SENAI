package br.com.apisenai.Repository;

import br.com.apisenai.domain.entity.ContentPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContentPageRepository extends JpaRepository<ContentPage, Long> {
    @Transactional
    @Modifying
    @Query("update ContentPage r set r.title = ?1 where r.id = ?2")
    void updateContentPageTitle(String title, Long Id);

    @Transactional
    @Modifying
    @Query("update ContentPage r set r.content = ?1 where r.id = ?2")
    void updatePageContent(String content, Long Id);
}

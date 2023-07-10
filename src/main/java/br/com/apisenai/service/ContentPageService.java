package br.com.apisenai.service;

import br.com.apisenai.Repository.ContentPageRepository;
import br.com.apisenai.domain.entity.ContentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentPageService {

    @Autowired
    ContentPageRepository contentPageRepository;

    public ContentPage createContentPage(ContentPage contentPage) {
        return contentPageRepository.save(contentPage);
    }
    public List<ContentPage> findAll() {
        return contentPageRepository.findAll();
    }

    public Optional<ContentPage> findById(Long id) {
        return contentPageRepository.findById(id);
    }
    public void updateContentPageTitle(String title, Long id) {
        contentPageRepository.updateContentPageTitle(title, id);
    }

    public void updatePageContent(String content, Long id) {
        contentPageRepository.updatePageContent(content, id);
    }

    public void deletePageContent(Long id) {
        contentPageRepository.deleteById(id);
    }
}

package br.com.apisenai.service;

import br.com.apisenai.Repository.ContentPageRepository;
import br.com.apisenai.domain.entity.ContentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContentPageService {

    @Autowired
    ContentPageRepository contentPageRepository;

    public ContentPage createContentPage(ContentPage contentPage) {
        return contentPageRepository.save(contentPage);
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
    public void deleteContentPageTitle(Long id) {
        contentPageRepository.deleteById(id);
    }
}

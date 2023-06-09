package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.ContentPage;
import br.com.apisenai.service.ContentPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contentPage")
public class ContentPageController {

    @Autowired
    ContentPageService contentPageService;

    @PostMapping("/createContentPage/")
    public ResponseEntity<String> createFanClub(@RequestBody ContentPage contentPage) {
        try {
            contentPageService.createContentPage(contentPage);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao cadastrar pagina de conteudo", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Pagina de conteudo cadastrado com sucesso!", HttpStatus.CREATED);
    }
    @GetMapping("/listContentPage")
    public List<ContentPage> findAll() {
        return contentPageService.findAll();
    }

    @GetMapping("/findContentPageById/{id}")
    public ContentPage findById(@PathVariable Long id) {
        return contentPageService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @PatchMapping("/updateContentPageTitle/{id}/{title}")
    public ResponseEntity<String> updateContentPageTitle(@PathVariable String title, @PathVariable Long id){
        try {
            contentPageService.updateContentPageTitle(title, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar titulo", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Titulo atualizado com sucesso!", HttpStatus.CREATED);
    }

    @PatchMapping("/updatePageContent/{id}/{content}")
    public ResponseEntity<String> updatePageContent(@PathVariable String content, @PathVariable Long id){
        try {
            contentPageService.updatePageContent(content, id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao atualizar conteudo", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Conteudo atualizada com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePageContent/{id}")
    public ResponseEntity<String> deletePageContent(@PathVariable Long id) {
        try {
            contentPageService.deletePageContent(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir pagina de conteudo", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Pagina de conteudo excluída com sucesso!", HttpStatus.CREATED);
    }
}

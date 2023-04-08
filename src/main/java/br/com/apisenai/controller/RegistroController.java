package br.com.apisenai.controller;

import br.com.apisenai.domain.entity.Registro;
import br.com.apisenai.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    RegistroService registroService;

    @PostMapping("/")
    public Registro novoRegistro(@RequestBody Registro registro) {
        return registroService.criarRegistro(registro);
    }

    @GetMapping("/")
    public List<Registro> findAll() {
        return registroService.findAll();
    }

    @GetMapping("/{id}")
    public Registro findById(@PathVariable Long id) {
        return registroService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/nome/{nome}")
    public List<Registro> findByName(@PathVariable String nome) {
        return registroService.findByName(nome);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        registroService.deleteRegistro(id);
    }

    @PatchMapping("/{email}/{id}")
    public void update(@PathVariable String email, @PathVariable Long id){
        registroService.atualizarRegistroEmail(email, id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Registro registro, @PathVariable Long id){
        registroService.atualizarRegistro(registro, id);
    }


}

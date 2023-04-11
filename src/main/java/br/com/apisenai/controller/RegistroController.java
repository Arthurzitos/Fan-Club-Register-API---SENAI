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

    @PostMapping("/createRegister")
    public Registro novoRegistro(@RequestBody Registro registro) {
        return registroService.criarRegistro(registro);
    }

    @GetMapping("/listRegister")
    public List<Registro> findAll() {
        return registroService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Registro findById(@PathVariable Long id) {
        return registroService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/findByName/{nome}")
    public List<Registro> findByName(@PathVariable String nome) {
        return registroService.findByName(nome);
    }

    @DeleteMapping("/deleteRegister/{id}")
    public void deleteById(@PathVariable Long id) {
        registroService.deleteRegistro(id);
    }

    @PatchMapping("/updateEmail/{id}/{email}")
    public void updateEmail(@PathVariable String email, @PathVariable Long id){
        registroService.atualizarRegistroEmail(email, id);
    }

    @PatchMapping("/updateSenha/{id}/{senha}")
    public void updateSenha(@PathVariable String senha, @PathVariable Long id){
        registroService.atualizarRegistroSenha(senha, id);
    }

    @PatchMapping("/updateNome/{id}/{nome}")
    public void updateNome(@PathVariable String nome, @PathVariable Long id){
        registroService.atualizarRegistroNome(nome, id);
    }

    @PatchMapping("/updateSobreNome/{id}/{sobrenome}")
    public void updateSobreNome(@PathVariable String sobrenome, @PathVariable Long id){
        registroService.atualizarRegistroSobreNome(sobrenome, id);
    }
    
    @PatchMapping("/updateApelido/{id}/{apelido}")
    public void updateApelido(@PathVariable String apelido, @PathVariable Long id){
        registroService.atualizarRegistroApelido(apelido, id);
    }
    

    @PutMapping("/updateRegister/{id}")
    public void update(@RequestBody Registro registro, @PathVariable Long id){
        registroService.atualizarRegistro(registro, id);
    }

}

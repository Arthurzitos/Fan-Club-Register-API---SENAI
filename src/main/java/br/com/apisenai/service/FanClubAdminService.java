package br.com.apisenai.service;

import br.com.apisenai.Repository.FanClubAdminRepository;
import br.com.apisenai.domain.entity.FanClubAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FanClubAdminService {

    @Autowired
    FanClubAdminRepository fanClubAdminRepository;

    public FanClubAdmin criarFanClubAdmin(FanClubAdmin FanClubAdmin) {
        return fanClubAdminRepository.save(FanClubAdmin);
    }

    public List<FanClubAdmin> findAll() {
        return fanClubAdminRepository.findAll();
    }

    public Optional<FanClubAdmin> findById(Long id) {
        return fanClubAdminRepository.findById(id);
    }

    public List<FanClubAdmin> findByName(String nome) {
        return fanClubAdminRepository.findFanClubAdminsByNomeIgnoreCase(nome);
    }

    public void deleteFanClubAdmin(Long id) {
        fanClubAdminRepository.deleteById(id);
    }

    public void atualizarFanClubAdminEmail(String email, Long id) {
        fanClubAdminRepository.atualizaEmail(email, id);
    }

    public void atualizarFanClubAdminSenha(String senha, Long id) {
        fanClubAdminRepository.atualizaSenha(senha, id);
    }

    public void atualizarFanClubAdminNome(String nome, Long id) {
        fanClubAdminRepository.atualizaNome(nome, id);
    }

    public void atualizarFanClubAdminSobreNome(String sobrenome, Long id) {
        fanClubAdminRepository.atualizaSobreNome(sobrenome, id);
    }
   
    public void atualizarFanClubAdmin(FanClubAdmin FanClubAdmin, Long id) {
        FanClubAdmin.setId(id);
        fanClubAdminRepository.save(FanClubAdmin);
    }
}

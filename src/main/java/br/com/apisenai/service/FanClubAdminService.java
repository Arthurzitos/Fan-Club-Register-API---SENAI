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

    public FanClubAdmin createFanClubAdmin(FanClubAdmin FanClubAdmin) {
        return fanClubAdminRepository.save(FanClubAdmin);
    }

    public List<FanClubAdmin> findAll() {
        return fanClubAdminRepository.findAll();
    }

    public Optional<FanClubAdmin> findById(Long id) {
        return fanClubAdminRepository.findById(id);
    }

    public List<FanClubAdmin> findByName(String name) {
        return fanClubAdminRepository.findFanClubAdminsByName(name);
    }

    public void deleteFanClubAdmin(Long id) {

        fanClubAdminRepository.deleteById(id);
    }

    public void updateFanClubAdminEmail(String email, Long id) {

        fanClubAdminRepository.updateEmail(email, id);
    }

    public void updateFanClubAdminPassword(String password, Long id) {
        fanClubAdminRepository.updatePassword(password, id);
    }

    public void updateFanClubAdminName(String name, Long id) {
        fanClubAdminRepository.updateName(name, id);
    }

    public void updateFanClubAdminSurname(String surname, Long id) {
        fanClubAdminRepository.updateSurname(surname, id);
    }
   
    public void updateFanClubAdmin(FanClubAdmin FanClubAdmin, Long id) {
        FanClubAdmin.setId(id);
        fanClubAdminRepository.save(FanClubAdmin);
    }
}

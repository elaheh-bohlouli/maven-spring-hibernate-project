package service.serviceClass;

import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmailRepository;
import service.EmailService;
import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceClass implements EmailService {


    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private Email email;


    @Override
    public void create(Email email) {
        emailRepository.save(email);
    }

    @Override
    public Optional<Email> findById(int id) {
        return emailRepository.findById(id);
    }


    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        emailRepository.deleteById(id);
    }

}


package service;

import model.Email;
import java.util.List;
import java.util.Optional;

public interface EmailService {
    void create(Email email);
    Optional<Email> findById(int id);
    List<Email> findAll();
    void deleteById(int id);
}

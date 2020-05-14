package com.ela.repository;

import com.ela.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmailRepository  extends JpaRepository<Email, Integer>{
}

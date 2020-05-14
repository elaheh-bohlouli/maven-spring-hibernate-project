package com.ela.repository;

import com.ela.model.AskDayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AskDayOffRepository extends JpaRepository<AskDayOff, Integer> {
}

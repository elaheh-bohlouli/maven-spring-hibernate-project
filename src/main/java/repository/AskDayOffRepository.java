package repository;

import model.AskDayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AskDayOffRepository  extends JpaRepository<AskDayOff, Integer>{}

package service;

import exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import exceptions.EmployeeIsNotHeadException;
import model.AskDayOff;
import model.Employee;
import java.util.List;
import java.util.Optional;

public interface AskDayOffService {
    void create(AskDayOff askDayOff);
    Optional<AskDayOff> findById(int id);
    List<AskDayOff> findAll();
    void deleteById(int id);
    void update(AskDayOff askDayOff);
    List<AskDayOff> findAllAskDayOff(Employee head) throws EmployeeIsNotHeadException;
    void acceptAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;
    void rejectAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;

}

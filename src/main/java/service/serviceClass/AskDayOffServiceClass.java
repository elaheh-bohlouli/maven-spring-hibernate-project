package service.serviceClass;

import exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import exceptions.EmployeeIsNotHeadException;
import model.AskDayOff;
import model.CategoryElements;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AskDayOffRepository;
import repository.CategoryElementRepository;
import service.AskDayOffService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AskDayOffServiceClass implements AskDayOffService {

    @Autowired
    private AskDayOffRepository askDayOffRepository;
    @Autowired
    private CategoryElementRepository categoryElementRepository;


    @Override
    public void create(AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @Override
    public Optional<AskDayOff> findById(int id) {
        return askDayOffRepository.findById(id);
    }

    @Override
    public List<AskDayOff> findAll() {
        return askDayOffRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        askDayOffRepository.deleteById(id);
    }

    @Override
    public void update(AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @Override
    public List<AskDayOff> findAllAskDayOff(Employee head) throws EmployeeIsNotHeadException {
        List<AskDayOff> askDayOffList = new ArrayList();
        if (!head.getCategoryElements().getRole().equals("head")) {
            throw new EmployeeIsNotHeadException();
        } else {
            Stream<AskDayOff> askDayOffStream = askDayOffRepository.findAll().stream()
                    .filter(askDayOff -> askDayOff.getEmployee().getHead().equals(head));
            askDayOffList.addAll(askDayOffList);
        }
        return askDayOffList;
    }

    @Override
    public void acceptAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOff(head)) {
            if (askDayOff.getId() != askDayOffId) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElements accepted = (CategoryElements) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("accepted"));
                askDayOff.setCategoryElements(accepted);
            }
        }
        ;
    }

    @Override
    public void rejectAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOff(head)) {
            if (askDayOff.getId() != askDayOffId) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElements accepted = (CategoryElements) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("rejected"));
                askDayOff.setCategoryElements(accepted);
            }
        }
        ;
    }
}
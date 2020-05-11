package service;

import Commen.ItemNotFoundException;
import controller.AskDayOffController;
import controller.CategoryElementController;
import model.AskDayOff;
import model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequestMapping(value = "/AskDayOffEachHead")
public class AskDayOffServices {

    AskDayOffController askDayOffController;
    List<AskDayOff> employeeAskDayOffsOneHead = new ArrayList<>();
    CategoryElementController categoryElementController;

    public List<AskDayOff> perHeadAskDayOff(@RequestParam Employee head) {
        for (AskDayOff askDayOff : askDayOffController.askDayOffList()) {
            if (askDayOff.getEmployee().getCategoryElements().getRole().equals(head)) {
                employeeAskDayOffsOneHead.add(askDayOff);
            }
        }
        return employeeAskDayOffsOneHead;
    }

    public void acceptAskDayOff(@RequestBody int id) throws ItemNotFoundException {
        for (AskDayOff askDayOff : employeeAskDayOffsOneHead) {
            if (askDayOff.getId()==id){
                askDayOff.setCategoryElements(categoryElementController.categoryElements(id));
            }
        };
    }

    public void rejectAskDayOff(@RequestBody int id) throws ItemNotFoundException {
        for (AskDayOff askDayOff : employeeAskDayOffsOneHead) {
            if (askDayOff.getId()==id){
                askDayOff.setCategoryElements(categoryElementController.categoryElements(id));
            }
        };
    }
}
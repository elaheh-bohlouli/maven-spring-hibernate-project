import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.ela");

        Category employee = new Category();
        employee.setActive(true);
        employee.setCreateDataTime(new Date());
        employee.setLastModifiedDataTime(new Date());
        employee.setManualId("id1");
        employee.setName("employee");

        Category email = new Category();
        email.setActive(true);
        email.setCreateDataTime(new Date());
        email.setLastModifiedDataTime(new Date());
        email.setManualId("id2");
        email.setName("email");

        Category askDayOff = new Category();
        askDayOff.setActive(true);
        askDayOff.setCreateDataTime(new Date());
        askDayOff.setLastModifiedDataTime(new Date());
        askDayOff.setManualId("id3");
        askDayOff.setName("askDayOff");

        CategoryElements head = new CategoryElements();
        head.setCategory(employee);
        head.setRole("head");
        head.setName("مدیر");

        CategoryElements dev = new CategoryElements();
        dev.setCategory(employee);
        dev.setRole("dev");
        dev.setName("دوولوپر");

        CategoryElements test = new CategoryElements();
        test.setCategory(employee);
        test.setRole("test");
        test.setName("تستر");

        CategoryElements askDayOffStatus1 = new CategoryElements();
        askDayOffStatus1.setCategory(askDayOff);
        askDayOffStatus1.setRole("register");
        askDayOffStatus1.setName("ثبت شده");

        CategoryElements askDayOffStatus2 = new CategoryElements();
        askDayOffStatus2.setCategory(askDayOff);
        askDayOffStatus2.setRole("accepted");
        askDayOffStatus2.setName("تایید شده");

        CategoryElements askDayOffStatus3 = new CategoryElements();
        askDayOffStatus3.setCategory(askDayOff);
        askDayOffStatus3.setRole("rejected");
        askDayOffStatus3.setName("رد شده");

        Employee employee1 = new Employee();
        employee1.setCategoryElements(head);
        employee1.setName("Ali");
        employee1.setLastName("Alizadeh");
        employee1.setActive(true);
        employee1.setLastModifiedDataTime(new Date());
        employee1.setCreateDataTime(new Date());
        employee1.setManualId("Id_092");

        Employee employee2 = new Employee();
        employee2.setHead(employee1);
        employee2.setCategoryElements(dev);
        employee2.setName("Hasan");
        employee2.setLastName("Hasani");
        employee2.setActive(true);
        employee2.setLastModifiedDataTime(new Date());
        employee2.setCreateDataTime(new Date());
        employee2.setManualId("Id_343");

        Employee employee3 = new Employee();
        employee3.setHead(employee1);
        employee3.setCategoryElements(dev);
        employee3.setName("Hamrah");
        employee3.setLastName("Hamrahi");
        employee3.setActive(true);
        employee3.setLastModifiedDataTime(new Date());
        employee3.setCreateDataTime(new Date());
        employee3.setManualId("Id_762");

        AskDayOff askDayOff1 = new AskDayOff();
        askDayOff1.setEmployee(employee2);
        askDayOff1.setCategoryElements(askDayOffStatus1);
        askDayOff1.setBeginDate(new Date());
        askDayOff1.setEndDate(new Date());
        askDayOff1.setActive(true);
        askDayOff1.setLastModifiedDataTime(new Date());

        Email email1 = new Email();
        email1.setEmployee(employee1);
        Set<Employee> employeeList = new HashSet<>();
        employeeList.add(employee2);
        employeeList.add(employee3);
        email1.setReceivers(employeeList);
        email1.setText("Hi every body");
        email1.setActive(true);
        email1.setCreateDataTime(new Date());
        email1.setLastModifiedDataTime(new Date());
        email1.setManualId("Id_43");


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(email);
        entityManager.persist(askDayOff);
        entityManager.persist(head);
        entityManager.persist(dev);
        entityManager.persist(test);
        entityManager.persist(askDayOffStatus1);
        entityManager.persist(askDayOffStatus2);
        entityManager.persist(askDayOffStatus3);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(askDayOff1);
        entityManager.persist(email1);


        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

}


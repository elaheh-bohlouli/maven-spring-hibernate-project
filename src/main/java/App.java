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

        CategoryElements send = new CategoryElements();
        send.setCategory(email);
        send.setRole("send");
        send.setName("ارسالی");

        CategoryElements received = new CategoryElements();
        received.setCategory(email);
        received.setRole("received");
        received.setName("دریافتی");

        CategoryElements register = new CategoryElements();
        register.setCategory(askDayOff);
        register.setRole("register");
        register.setName("ثبت شده");

        CategoryElements accepted = new CategoryElements();
        accepted.setCategory(askDayOff);
        accepted.setRole("accepted");
        accepted.setName("تایید شده");

        CategoryElements reject = new CategoryElements();
        reject.setCategory(askDayOff);
        reject.setRole("reject");
        reject.setName("رد شده");

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
        askDayOff1.setEmployee(employee1);
        askDayOff1.setCategoryElements(register);
        askDayOff1.setBeginDate(new Date());
        askDayOff1.setEndDate(new Date());
        askDayOff1.setActive(true);
        askDayOff1.setLastModifiedDataTime(new Date());

        Email email1 = new Email();
        email1.setEmployee(employee1);
        Set<Employee> employeeList = new HashSet<>();
        employeeList.add(employee2); employeeList.add(employee3);
        email1.setReceivers(employeeList);
        email1.setText("Hi every body");
        email1.setActive(true);
        email1.setCategoryElements(send);
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
        entityManager.persist(send);
        entityManager.persist(received);
        entityManager.persist(register);
        entityManager.persist(accepted);
        entityManager.persist(reject);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(askDayOff1);


        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

}


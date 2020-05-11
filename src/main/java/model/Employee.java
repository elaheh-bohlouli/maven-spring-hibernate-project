package model;

import javax.persistence.*;

@Entity
@Table(name = "t_Employee")
public class Employee extends Entities {

    @Column(name = "c_Name")
    private String name;

    @Column(name = "c_LastName")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "c_head")
    private Employee head;

    @ManyToOne
    @JoinColumn(name="c_categoryElements")
    private CategoryElements categoryElements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public CategoryElements getCategoryElements() {
        return categoryElements;
    }

    public void setCategoryElements(CategoryElements categoryElements) {
        this.categoryElements = categoryElements;
    }
}

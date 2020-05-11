package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_AskDataOff")
public class AskDayOff extends Entities {

    @Column(name = "c_BeginDate")
    private Date beginDate;

    @Column(name = "c_EndDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "c_status")
    private CategoryElements status;

    @ManyToOne
    @JoinColumn(name = "c_Employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="c_categoryElements")
    private CategoryElements categoryElements;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CategoryElements getStatus() {
        return status;
    }

    public void setStatus(CategoryElements status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CategoryElements getCategoryElements() {
        return categoryElements;
    }

    public void setCategoryElements(CategoryElements categoryElements) {
        this.categoryElements = categoryElements;
    }
}


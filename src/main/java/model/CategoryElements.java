package model;

import javax.persistence.*;

@Entity
@Table(name = "t_CategoryElements")
public class CategoryElements extends Entities {

    @Column(name = "c_Role")
    private String role;

    @Column(name = "c_Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "c_Category")
    private Category category;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}


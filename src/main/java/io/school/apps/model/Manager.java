package io.school.apps.model;

import javax.persistence.*;

@Entity(name = "Manager")
@Table(name = "manager")
public class Manager {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")
    private Long id;
    @Column(name = "managername", nullable = false)
    private String managerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}

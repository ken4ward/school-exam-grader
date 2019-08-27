package io.school.apps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.school.apps.audit.Auditing;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "student")
@DynamicUpdate
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "studentname", nullable = false)
    private String studentName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", nullable = false, referencedColumnName = "id") @JsonIgnore
    private Manager manager;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_schoolclass",  joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "schoolclass_id", referencedColumnName = "id"))
    private Set<SchoolClass> schoolClasses;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

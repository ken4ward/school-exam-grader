package io.school.apps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.school.apps.audit.Auditing;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity(name = "SchoolClass")
@Table(name = "schoolclass")
@DynamicUpdate
public class SchoolClass {

    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "schoolclassname", nullable = false)
    private String schoolClassName;

    @ManyToMany(mappedBy = "schoolClasses")
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", nullable = false, referencedColumnName = "id") @JsonIgnore
    private Manager manager;

    @ManyToMany(mappedBy = "schoolClasses")
    private List<Student> students = new ArrayList<Student>();

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolClassName() {
        return schoolClassName;
    }

    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
    }
}

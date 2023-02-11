import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "students")
@Setter
@Getter
@Accessors(chain = true)
public class Student {

    @Column(name = "applied")
    private Integer applied;
    @Column(name = "groupId")
    private Integer group;
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(String name, int applied) {
        this.name = name;
        this.applied = applied;
    }

    public Student(String name, int applied, int group) {
        this.name = name;
        this.applied = applied;
        this.group = group;
    }

    @Override

    public String toString() {
        return "id= " + id +
                ", name= " + name + ", group= " + group + ", applied= " + applied;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

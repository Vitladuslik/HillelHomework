import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Setter
@Getter
@Accessors(chain = true)
public class Student {

    @Column(name = "applied")
    private Integer applied;
    @Column(name = "groupId")
    private Integer groupId;
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

    public Student(String name, int applied, int groupId) {
        this.name = name;
        this.applied = applied;
        this.groupId = groupId;
    }

    @Override

    public String toString() {
        return "id= " + id +
                ", name= " + name + ", group= " + groupId + ", applied= " + applied;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

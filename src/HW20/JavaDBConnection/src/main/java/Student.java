import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Student {
    private int id;
    @CsvBindByPosition(position = 0)
    private String name;
    private int group;

    private int applied;

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public Student(int id, String name, int applied) {
        this.id = id;
        this.name = name;
        this.applied = applied;
    }

    public Student(int id, String name, int applied, int group) {
        this.id = id;
        this.name = name;
        this.applied = applied;
        this.group = group;
    }

    @Override

    public String toString() {
        return "id= " + id +
                ", name= " + name;
    }
}

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandlerImpl implements DatabaseHandler {

    @Override
    public boolean addStudent(Student student) {
        try {

            Session session = HibernateService.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            HibernateService.shutdown();

            return true;

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public List<Student> getAll() {

        List<Student> result;

        try {

            Session session = HibernateService.getSessionFactory().openSession();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> rootEntry = cq.from(Student.class);
            CriteriaQuery<Student> all = cq.select(rootEntry);

            TypedQuery<Student> allQuery = session.createQuery(all);

            result = allQuery.getResultList();

            HibernateService.shutdown();

            return result;

        } catch (Exception e) {
            System.err.println("Error!");
            HibernateService.shutdown();
            return null;
        }


    }

    @Override
    public List<Student> getByName(String name) {

        List<Student> result;

        try {
            Session session = HibernateService.getSessionFactory().openSession();

            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("name", name));

            result = (List<Student>) criteria.list();


            HibernateService.shutdown();

            return result;
        } catch (Exception e) {
            System.err.println("Error!");
            HibernateService.shutdown();
            return null;
        }

    }


    @Override
    public List<Student> getByIds(List<Integer> ids) {

        List<Student> result = new ArrayList<>();

        try {

            Session session = HibernateService.getSessionFactory().openSession();

            for (long i : ids) {

                Student s = session.get(Student.class, i);
                if (s != null) {
                    result.add(s);
                }
            }

            HibernateService.shutdown();

            return result;

        } catch (Exception e) {
            System.err.println("Error!");
            HibernateService.shutdown();
            return null;
        }

    }

}

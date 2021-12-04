package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public List<User> listCar(String model, int series) {
        List<User> users = null;


        try (Session session = sessionFactory.openSession()) {

            users = session.createQuery("from User u  where Car.model=:model and Car.series=:series",User.class)
                    .setParameter("model",model)
                    .setParameter("series",series)
                    .getResultList();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}

package hiber.dao;

import hiber.model.Car;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listUsers() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}

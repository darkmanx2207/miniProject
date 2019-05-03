package com.roma.hometestwork.repository.armchairRepository;

import com.roma.hometestwork.domain.Armchair;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateArmchairRepository implements ArmchairRepository {

    private final SessionFactory sessionFactory;

    public HibernateArmchairRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(Armchair armchair) {
        sessionFactory.getCurrentSession().save(armchair);
        return armchair.getId();
    }

    @Override
    public Optional<Armchair> findArmchairById(Long id) {
        Armchair armchair = (Armchair) sessionFactory.getCurrentSession().createCriteria(Armchair.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(armchair);
    }

    @Override
    public List<Armchair> showAllArmchairs() {
        return sessionFactory.getCurrentSession().createCriteria(Armchair.class).list();
    }

    @Override
    public void deleteArmchair(Armchair armchair) {
        sessionFactory.getCurrentSession().delete(armchair);
    }
}
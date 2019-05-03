package com.roma.hometestwork.repository.chairRepository;

import com.roma.hometestwork.domain.Chair;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateChairRepository implements ChairRepository {

    private final SessionFactory sessionFactory;

    public HibernateChairRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Chair chair) {
        sessionFactory.getCurrentSession().save(chair);
        return chair.getId();
    }

    @Override
    public Optional<Chair> findChairById(Long id) {
        Chair chair = (Chair) sessionFactory.getCurrentSession().createCriteria(Chair.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(chair);
    }

    @Override
    public List<Chair> showAllChairs() {
        return sessionFactory.getCurrentSession().createCriteria(Chair.class).list();
    }

    @Override
    public void deleteChair(Chair chair) {
        sessionFactory.getCurrentSession().delete(chair);

    }
}
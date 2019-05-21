package com.roma.hometestwork.repository.officeChairRepository;

import com.roma.hometestwork.domain.OfficeChair;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateOfficeChairRepository implements OfficeChairRepository {

    private final SessionFactory sessionFactory;

    public HibernateOfficeChairRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(OfficeChair officeChair) {
        sessionFactory.getCurrentSession().save(officeChair);
        return officeChair.getId();
    }

    @Override
    public Optional<OfficeChair> findOfficeChairById(Long id) {
        OfficeChair officeChair = (OfficeChair) sessionFactory.getCurrentSession().createCriteria(OfficeChair.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(officeChair);
    }

    @Override
    public List<OfficeChair> showAllOfficeChairs() {
        return sessionFactory.getCurrentSession().createCriteria(OfficeChair.class).list();
    }

    @Override
    public void deleteOfficeChair(OfficeChair officeChair) {
        sessionFactory.getCurrentSession().delete(officeChair);

    }
}

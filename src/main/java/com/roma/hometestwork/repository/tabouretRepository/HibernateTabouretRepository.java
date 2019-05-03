package com.roma.hometestwork.repository.tabouretRepository;

import com.roma.hometestwork.domain.Tabouret;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateTabouretRepository implements TabouretRepository {

    private final SessionFactory sessionFactory;

    public HibernateTabouretRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Tabouret tabouret) {
        sessionFactory.getCurrentSession().save(tabouret);
        return tabouret.getId();
    }

    @Override
    public Optional<Tabouret> findTabouretById(Long id) {
        Tabouret tabouret = (Tabouret) sessionFactory.getCurrentSession().createCriteria(Tabouret.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(tabouret);
    }

    @Override
    public List<Tabouret> showAllTabourets() {
        return sessionFactory.getCurrentSession().createCriteria(Tabouret.class).list();
    }

    @Override
    public void deleteTabouret(Tabouret tabouret) {
        sessionFactory.getCurrentSession().delete(tabouret);
    }
}
package com.service.impl;

import com.model.Comment;
import com.service.CommentService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class HibernateCommentImpl implements CommentService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
//            sessionFactory.close();
            entityManager = sessionFactory.createEntityManager();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Comment> findAll() {
        String queryStr = "select c from Comment as c";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findOne(Long id) {
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id = :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Comment save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = findOne(comment.getId());
            origin.setStart(comment.getStart());
            origin.setName(comment.getName());
            origin.setFeedback(comment.getFeedback());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Comment> save(List<Comment> t) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Comment> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void delete(List<Comment> t) {

    }

    @Override
    public void deleteAll() {

    }
}

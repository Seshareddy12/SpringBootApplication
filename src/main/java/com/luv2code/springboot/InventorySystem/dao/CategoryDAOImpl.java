package com.luv2code.springboot.InventorySystem.dao;

import com.luv2code.springboot.InventorySystem.entity.Category;
import com.luv2code.springboot.InventorySystem.entity.Item;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryDAOImpl implements  CategoryDAO{
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Category> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Category> theQuery = session.createQuery("from Category",Category.class);

        List<Category> categories = theQuery.getResultList();

        return categories;

    }


    @Transactional
    public Category findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Category category = session.get(Category.class,id);
        return category;
    }
    @Transactional
    @Override
    public void save(Category category) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(category);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query theQuery = session.createQuery("delete from Category where id=:Id");

        theQuery.setParameter("Id",id);
        theQuery.executeUpdate();
    }

    @Override
    public void addItem(int catId, Item item) {
        Session session = entityManager.unwrap(Session.class);
        Category category = session.get(Category.class,catId);

        category.add(item);
        session.saveOrUpdate(category);
    }


}

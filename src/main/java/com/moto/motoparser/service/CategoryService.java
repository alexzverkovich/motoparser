package com.moto.motoparser.service;

import com.moto.motoparser.config.hibernate.HibernateSessionFactory;
import com.moto.motoparser.model.ShopCategoryEntity;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryService {

    public List<ShopCategoryEntity> getCategories() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ShopCategoryEntity> criteriaQuery = cb.createQuery(ShopCategoryEntity.class);
        Root<ShopCategoryEntity> rootEntry = criteriaQuery.from(ShopCategoryEntity.class);
        CriteriaQuery<ShopCategoryEntity> allCategories = criteriaQuery.select(rootEntry);

        TypedQuery<ShopCategoryEntity> allQuery = session.createQuery(allCategories);
        List<ShopCategoryEntity> categories = allQuery.getResultList();
        session.close();

        return categories;
    }

    public ShopCategoryEntity getCategoryById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return (ShopCategoryEntity) session.get(ShopCategoryEntity.class, id);
    }
}

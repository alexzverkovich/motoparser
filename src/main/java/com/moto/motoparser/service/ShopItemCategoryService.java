package com.moto.motoparser.service;

import com.moto.motoparser.config.hibernate.HibernateSessionFactory;
import com.moto.motoparser.model.ShopShopitemCategoriesEntity;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ShopItemCategoryService {

    public ShopShopitemCategoriesEntity getShopItemCategory(Integer shopItemId) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ShopShopitemCategoriesEntity> criteriaQuery = cb.createQuery(ShopShopitemCategoriesEntity.class);
        Root<ShopShopitemCategoriesEntity> rootEntry = criteriaQuery.from(ShopShopitemCategoriesEntity.class);
        CriteriaQuery<ShopShopitemCategoriesEntity> shopItemQuery = criteriaQuery.select(rootEntry).where(cb.equal(rootEntry.get("shopItem"), shopItemId));


        TypedQuery<ShopShopitemCategoriesEntity> query = session.createQuery(shopItemQuery);
        ShopShopitemCategoriesEntity shopItemCategory = query.getSingleResult();
        session.close();

        return shopItemCategory;
    }
}

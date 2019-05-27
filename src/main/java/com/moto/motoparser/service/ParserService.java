package com.moto.motoparser.service;

import com.moto.motoparser.config.hibernate.HibernateSessionFactory;
import com.moto.motoparser.model.ShopItemEntity;
import com.moto.motoparser.model.ShopItemKindEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.moto.motoparser.helper.ParserHelper.parseShopItemEntity;
import static java.lang.String.format;

@Service
public class ParserService {

    Logger log = Logger.getLogger(ParserService.class);

    public String parseFile(CommonsMultipartFile file){

        List<ShopItemEntity> shopItemEntities = newArrayList();
        List<ShopItemKindEntity> shopItemKindEntities = newArrayList();
        List<String> parsingResult = parseShopItemEntity(file, shopItemEntities, shopItemKindEntities);
        if (!parsingResult.isEmpty()) {

            String msg = parsingResult.stream().map(Object::toString).collect(Collectors.joining("\n"));
            return msg;
        }



        //TODO add update here, not only insert

        for(ShopItemEntity entity : shopItemEntities){
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
        }

       /* for(ShopItemKindEntity entity : shopItemKindEntities){
            session.save(entity);
        }*/



        return format("OK. File parsed. %s records inserted", shopItemEntities.size());
    }
}

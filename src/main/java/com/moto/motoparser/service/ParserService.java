package com.moto.motoparser.service;

import com.moto.motoparser.config.hibernate.HibernateSessionFactory;
import com.moto.motoparser.model.ShopItemEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import static com.moto.motoparser.helper.ParserHelper.parseShopItemEntity;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class ParserService {

    Logger log = Logger.getLogger(ParserService.class);

    public String parseFile(CommonsMultipartFile file){

        String uploadResult = "Conn not tested...";

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        ShopItemEntity shopItemEntity = new ShopItemEntity();
        String parsingResult = parseShopItemEntity(file, shopItemEntity);
        if (isNotBlank(parsingResult)) {
            return "Error occurred while parsing input file." + parsingResult;
        }

        session.save(shopItemEntity);
        session.getTransaction().commit();
        session.close();

        return "OK. File parsed.";
    }
}

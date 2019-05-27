package com.moto.motoparser.helper;

import com.moto.motoparser.model.ShopItemEntity;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;

public class ParserHelper {

    private static Logger log = Logger.getLogger(ParserHelper.class);

    public static List<String> parseShopItemEntity(CommonsMultipartFile file, List<ShopItemEntity> shopItemEntities) {

        List<String> errs = newArrayList();
        String msg  = "";
        try {

            if (file.isEmpty()) {
                msg = "Cannot parse empty file!";
                log.error(msg);
                errs.add(msg);
                return errs;
            }

            if (file.getName().matches(".\\.xls")) {
                msg = format("File has wrong extension: %s. Only .xls files can be parsed.", file.getName());
                log.error(msg);
                errs.add(msg);
                return errs;
            }

            //because POI can't work with CommonsMultipartFile
            File tmpFile = File.createTempFile("temp", ".xls");
            FileUtils.writeByteArrayToFile(tmpFile, file.getBytes());

            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(tmpFile));
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;

            for(int rowNdx = 1; rowNdx < sheet.getPhysicalNumberOfRows(); rowNdx++) {
                row = sheet.getRow(rowNdx);
                if(row != null) {
                    shopItemEntities.add(parseOneRow(row));
                }
            }
        } catch (Exception e) {
            log.error(msg);
            errs.add(msg);
        }
        return errs;
    }

    private static ShopItemEntity parseOneRow(HSSFRow row) {

        HSSFCell cell = row.getCell(0);

        /*shopItemEntity.setId();
        shopItemEntity.setOrder();
        shopItemEntity.setTitle();
        shopItemEntity.setSlug();
        shopItemEntity.setLastChanged();
        shopItemEntity.setPublished();
        shopItemEntity.setPublishedOn();
        shopItemEntity.setPublishedOff();
        shopItemEntity.setFavorite();
        shopItemEntity.setIsNew();
        shopItemEntity.setItemKindsLi();
        shopItemEntity.setCreated();
        shopItemEntity.setModify();
        shopItemEntity.setMetaKeywords();
        shopItemEntity.setMetaDescription();
        shopItemEntity.setAvatar();
        shopItemEntity.setCropping();
        shopItemEntity.setPreview();
        shopItemEntity.setText();
        shopItemEntity.setYandexTitle();
        shopItemEntity.setTypePrefix();
        shopItemEntity.setVendor();
        shopItemEntity.setModelName();
        shopItemEntity.setCountryOfOrigin();
        shopItemEntity.setSalesNotes();
        shopItemEntity.setManufacturerWarranty();
        shopItemEntity.setStore();
        shopItemEntity.setPickup();
        shopItemEntity.setDelivery();
        shopItemEntity.setTags();*/
        return null;
    }
}

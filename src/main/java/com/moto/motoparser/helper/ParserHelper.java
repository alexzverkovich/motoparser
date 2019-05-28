package com.moto.motoparser.helper;

import com.moto.motoparser.model.ShopCategoryEntity;
import com.moto.motoparser.model.ShopItemEntity;
import com.moto.motoparser.model.ShopItemKindEntity;
import com.moto.motoparser.model.ShopShopitemCategoriesEntity;
import com.moto.motoparser.service.CategoryService;
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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;

public class ParserHelper {

    private static Logger log = Logger.getLogger(ParserHelper.class);
    private static CategoryService categoryService = new CategoryService();

    public static List<String> parseShopItemEntity(String category, CommonsMultipartFile file,
                                                   List<ShopItemEntity> shopItemEntities,
                                                   List<ShopItemKindEntity> shopItemKindEntities,
                                                   List<ShopShopitemCategoriesEntity>  shopShopitemCategoriesEntities) {

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
                    parseOneRow(row, shopItemEntities, shopItemKindEntities, shopShopitemCategoriesEntities, category);
                }
            }
        } catch (Exception e) {
            msg = "Error occurred: "+e;
            log.error(msg);
            errs.add(msg);
        }
        return errs;
    }

    private static void parseOneRow(HSSFRow row,
                                    List<ShopItemEntity> shopItemEntities,
                                    List<ShopItemKindEntity> shopItemKindEntities,
                                    List<ShopShopitemCategoriesEntity> shopShopitemCategoriesEntities,
                                    String category) {

        ShopItemEntity shopItemEntity = new ShopItemEntity();

        HSSFCell cell = row.getCell(0); //ID

        Integer id = (int) cell.getNumericCellValue();

        //sometimes we have empty rows in import file, for them id=0. Should skip them.
        if(id == 0){
            return;
        }
        shopItemEntity.setId(id);
        shopItemEntity.setOrder(id);

        cell = row.getCell(1);
        String title = cell.getStringCellValue();
        shopItemEntity.setTitle(title);

        shopItemEntity.setPublished((byte)1);

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        shopItemEntity.setPublishedOn(timestamp);
        shopItemEntity.setLastChanged(timestamp);
        shopItemEntity.setCreated(timestamp);
        shopItemEntity.setModify(timestamp);

        cell = row.getCell(14);
        shopItemEntity.setPreview(cell.getStringCellValue());

        shopItemEntity.setStore((byte)1);
        shopItemEntity.setPickup((byte)1);
        shopItemEntity.setDelivery((byte)1);

        //TODO set real slug here
        shopItemEntity.setSlug("");

        //set other fields to empty, because they can't be null in database
        shopItemEntity.setFavorite((byte)0);
        shopItemEntity.setIsNew((byte)0);
        shopItemEntity.setItemKindsLi("");
        shopItemEntity.setMetaKeywords("");
        shopItemEntity.setMetaDescription("");
        shopItemEntity.setCropping("");
        shopItemEntity.setText("");
        shopItemEntity.setYandexTitle("");
        shopItemEntity.setTypePrefix("");
        shopItemEntity.setVendor("");
        shopItemEntity.setModelName("");
        shopItemEntity.setCountryOfOrigin("");
        shopItemEntity.setSalesNotes("");
        shopItemEntity.setManufacturerWarranty((byte)0);
        shopItemEntity.setTags("");

        shopItemEntities.add(shopItemEntity);

        ShopItemKindEntity shopItemKindEntity = new ShopItemKindEntity();
        shopItemKindEntity.setId(shopItemEntity.getId());
        shopItemKindEntity.setOrder(shopItemEntity.getOrder());
        shopItemKindEntity.setShopShopitemByItemId(shopItemEntity);

        shopItemKindEntity.setTitle(shopItemEntity.getTitle());
        shopItemKindEntity.setQuantity((int)100);
        shopItemKindEntity.setCanBuy((byte)1);
        shopItemKindEntity.setPropertiesDict("N.");
        shopItemKindEntity.setCreated(timestamp);
        shopItemKindEntity.setModify(timestamp);

        cell = row.getCell(5);
        shopItemKindEntity.setPrice(id);

        //set other fields to empty, because they can't be null in database
        shopItemKindEntity.setDesc("");
        shopItemKindEntity.setCropping("");
        shopItemKindEntity.setNumberCatalog("");
        shopItemKindEntity.setOldPrice(0);
        shopItemKindEntity.setProductSize("");
        shopItemKindEntity.setWeight("");

        shopItemKindEntities.add(shopItemKindEntity);

        ShopShopitemCategoriesEntity shopShopitemCategoriesEntity = new ShopShopitemCategoriesEntity();
        shopShopitemCategoriesEntity.setShopItem(shopItemEntity);

        ShopCategoryEntity categoryEntity = categoryService.getCategoryById(Integer.parseInt(category));
        shopShopitemCategoriesEntity.setCategory(categoryEntity);

        shopShopitemCategoriesEntities.add(shopShopitemCategoriesEntity);

    }
}

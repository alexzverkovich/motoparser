package com.moto.motoparser.controller;

import com.moto.motoparser.model.forms.MyUploadForm;
import com.moto.motoparser.model.ShopCategoryEntity;
import com.moto.motoparser.service.CategoryService;
import com.moto.motoparser.service.ParserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UploadController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == MyUploadForm.class) {

            // Register to handle the conversion between the multipart object
            // and byte array.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.GET)
    public String upload(Model model) {

        CategoryService categoryService = new CategoryService();

        MyUploadForm myUploadForm = new MyUploadForm();
        List<ShopCategoryEntity> categories =   categoryService.getCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("myUploadForm", myUploadForm);
        return "upload";
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model,
                                           @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {

        ParserService parserService = new ParserService();

        if (ArrayUtils.isEmpty(myUploadForm.getFileDatas())){
            model.addAttribute("uploadedFiles", "No files to upload were provided");
            return "fileUpload";
        }

        try {
            String uploadResult = parserService.parseFile(myUploadForm.getFileDatas()[0]);
            model.addAttribute("description", myUploadForm.getCategory());
            model.addAttribute("uploadedFiles", uploadResult);
        }catch(Exception e){
            model.addAttribute("uploadedResult", "Error occurred: "+ e);
        }

        return "fileUpload";
    }
}

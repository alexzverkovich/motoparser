package com.moto.motoparser.model.forms;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MyUploadForm {

    private String category;

    // Upload files.
    private CommonsMultipartFile[] fileDatas;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CommonsMultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(CommonsMultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }

}

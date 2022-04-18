package com.aston.ecommerce.asmar.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageSaveDTO {

    private MultipartFile file;
    private Integer id;
    private boolean principal;

    public ImageSaveDTO(MultipartFile file, Integer id, boolean principal) {
        this.file = file;
        this.id = id;
        this.principal = principal;
    }

    public ImageSaveDTO() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "ImageSaveDTO{" +
                "file=" + file +
                ", id=" + id +
                ", principal=" + principal +
                '}';
    }
}

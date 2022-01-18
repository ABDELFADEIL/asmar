package com.aston.ecommerce.asmar.dto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ImageSaveDTO {

    private MultipartFile file;
    private Long id;
    private boolean principal;

    public ImageSaveDTO(MultipartFile file, Long id, boolean principal) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

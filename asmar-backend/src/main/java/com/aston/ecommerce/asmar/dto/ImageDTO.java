package com.aston.ecommerce.asmar.dto;

public class ImageDTO {

    private Integer id;
    private String url;
    private boolean principal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", principal=" + principal +
                '}';
    }
}

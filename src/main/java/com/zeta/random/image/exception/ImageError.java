package com.zeta.random.image.exception;

import lombok.Getter;

public enum ImageError {
    IMAGE_ERROR("IMG-101", "Please Try Later");

    String erroCode;
    String Descritpion;

    ImageError(String errorCode, String descritpion) {
        this.erroCode = errorCode;
        this.Descritpion = descritpion;
    }

    public String getDescritpion() {
        return Descritpion;
    }
    public String getErroCode() {
        return erroCode;
    }

}

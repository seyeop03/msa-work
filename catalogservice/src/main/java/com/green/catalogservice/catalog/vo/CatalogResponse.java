package com.green.catalogservice.catalog.vo;

import com.green.catalogservice.catalog.jpa.CatalogEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogResponse {

    private String email;
    private String name;

    public static CatalogResponse from(CatalogEntity entity){
        return new CatalogResponse(entity.getEmail(), entity.getName());
    }
}

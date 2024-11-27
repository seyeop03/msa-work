package com.green.catalogservice.catalog.service;

import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import org.springframework.stereotype.Service;

@Service
public interface CatalogService {

    void join(CatalogRequest catalogRequest);

    CatalogResponse getOrder(Long userId);
}

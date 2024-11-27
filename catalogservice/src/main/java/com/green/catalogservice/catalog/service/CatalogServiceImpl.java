package com.green.catalogservice.catalog.service;

import com.green.catalogservice.error.CatalogException;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public void join(CatalogRequest catalogRequest) {

        String email = catalogRequest.getEmail();

        catalogRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new CatalogException(String.format("User email %s already exist", email));
                });

        CatalogEntity entity = catalogRequest.toEntity();
        entity.setUserId(UUID.randomUUID().toString());

        catalogRepository.save(entity);
    }

    @Override
    public CatalogResponse getOrder(Long userId) {

        CatalogEntity catalogEntity = catalogRepository.findById(userId)
                .orElseThrow(() -> new CatalogException(String.format("User id %s not found", userId)));

        return CatalogResponse.from(catalogEntity);
    }
}

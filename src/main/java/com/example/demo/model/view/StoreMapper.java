package com.example.demo.model.view;

import com.example.demo.model.aggregate.Store;

public interface StoreMapper {
    static StoreDto toDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .latitude(store.getLocation().getX())
                .longitude(store.getLocation().getY()).build();
    }
}

package com.example.demo.interfaces.rest;


import com.example.demo.model.aggregate.Store;
import com.example.demo.model.repositories.StoreRepository;
import com.example.demo.model.view.StoreDto;
import com.example.demo.model.view.StoreMapper;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/")
    public List<StoreDto> listStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream().map(StoreMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/insert")
    public String addStore() throws ParseException {
        Random r = new Random();

        // 서울:
        // X (Longitude): 126° 58’ 41” E (126.97806)
        // Y (Latitude): 37° 34’ 00” N (37.56667),

        String pointWKT = String.format("POINT(%s %s)", 126. + r.nextDouble(), 37. + r.nextDouble());
//        Store store = new Store(new Point(r.nextDouble(), r.nextDouble()));
        Store store = new Store(pointWKT, (Point) new WKTReader().read(pointWKT));
        storeRepository.save(store);
        return "Success";
    }
}

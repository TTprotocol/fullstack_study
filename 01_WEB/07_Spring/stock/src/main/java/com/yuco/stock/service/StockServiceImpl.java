package com.yuco.stock.service;

import com.yuco.stock.dto.StockDTO;
import com.yuco.stock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockMapper mapper;
    private final static String BASE_DIR = "c:/upload/stock";

    @Override
    public List<StockDTO> getList() {
        log.info("getList");
        return mapper
            .getList()
            .stream()
            .map(StockDTO::of)
            .toList();
    }
}

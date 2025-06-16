package com.yuco.stock.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StockVO {
    private Long no;
    private String stockCode;
    private String stockName;
    private Long price;
    private String description;
    private Date regDate;
}

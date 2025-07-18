package com.yuco.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockVO {
    private Long no;
    private String stockCode;
    private String stockName;
    private Long price;
    private String description;
    private Date regDate;
}

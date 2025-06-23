package com.yuco.stock.dto;

import com.yuco.stock.domain.StockVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDTO {
    private Long no;
    private String stockCode;
    private String stockName;
    private Long price;
    private String description;
    private Date regDate;

    public static StockDTO of(StockVO vo) {
        return vo == null ? null : StockDTO.builder()
            .no(vo.getNo())
            .stockCode(vo.getStockCode())
            .stockName(vo.getStockName())
            .price(vo.getPrice())
            .description(vo.getDescription())
            .regDate(vo.getRegDate())
            .build();
    }

    public StockVO toVo() {
        return StockVO.builder()
            .no(no)
            .stockCode(stockCode)
            .stockName(stockName)
            .price(price)
            .description(description)
            .regDate(regDate)
            .build();
    }
}

package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Optional;

public interface TravelDao {
    void insert(TravelVO travel);

    void insertImage(TravelImageVO image);

    int getTotalCount();

    List<String> getDistricts();    // 권역 목록 얻기

    List<TravelVO> getTraverls(); // 목록 얻기

    List<TravelVO> getTraverls(int page);   // 페이지별 목록 얻기

    List<TravelVO> getTraverls(String district);    // 해당 권역의 목록 얻기

    Optional<TravelVO> getTravel(Long no);  // 특정 관광지 정보 얻기
}

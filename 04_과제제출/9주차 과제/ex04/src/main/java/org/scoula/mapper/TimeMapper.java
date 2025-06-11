package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    // 어노테이션 기반 SQL - 현재 시간 조회
    @Select("Select sysdate()")
    public String getTime();

    // getTime2()는 XML 매퍼에 SQL 정의 예정
    public String getTime2();
    // mapper.xml에서 select문을 지우면 에러 => xml 파일에 정의가 되어있지 않아서.
}

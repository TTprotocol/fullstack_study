package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {
    //    @Select("select * from tbl_board order by no desc")
    List<BoardVO> getList();

    BoardVO get(Long no);

    void create(BoardVO board);

    int update(BoardVO board);

    int delete(Long no);

    void createAttachment(BoardAttachmentVO attach);

    List<BoardAttachmentVO> getAttachmentList(Long bno);

    BoardAttachmentVO getAttachment(Long no);

    int deleteAttachment(Long no);

    int getTotalCount();    // 전체 페이지 가져오기

    List<BoardVO> getPage(PageRequest pageRequest); // 페이지네이션을 위한 페이지 가져오기
}

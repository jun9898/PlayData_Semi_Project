package com.example.project.mapper;

import com.example.project.dto.TagDto;
import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.request.map.SearchMapDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.map.MarketDocumentDTO;
import com.example.project.dto.response.map.MarketReviewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.dto.response.write.BoardWriteDTO;
import com.example.project.dto.response.write.BoardWriteFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<ContentDTO> getContentList(RequestContentDTO dto);
    List<ContentDTO> getFollowContentList(RequestContentDTO dto);

    int createTmpMarketList();
    int insertTmpMarketList(List<MarketDocumentDTO> dto);
    int upsertMarketList(List<MarketDocumentDTO> dto);
    int dropTmpMarketList();
    List<MarketReviewDTO> getMarketAndReviewList(SearchMapDTO dto);

    List<TagDto> getTagList();

    void insertBoardWrite(BoardWriteDTO boardWriteDTO);
    int fileinsert(List<BoardWriteFileDTO> boardWriteFileDTO);

    BoardWriteDTO selectMarketSeq(String name);
    int updateBoardWrite(BoardWriteDTO board);
    int deleteBoardWrite(Long review_seq);
}

package com.example.project.controller.api;

import com.example.project.dto.response.rank.MarketRankDTO;
import com.example.project.dto.response.rank.ReviewRankDTO;
import com.example.project.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class RankApiController {
        private final RankService service;

//        @GetMapping("/rank")
//        public List<MarketRankDTO> reviewRank(@ModelAttribute MarketRankDTO dto, HttpSession res){
//                System.out.println("dto = " + dto);
//                UserDTO session = (UserDTO)res.getAttribute("user");
//                if(session!=null){
//                        dto.setUser_seq(session.getUser_seq());
//                }
//                log.info(dto.toString());
//
//                List<MarketRankDTO> list = service.getMarketRankingInfo(dto);
//                System.out.println("list = " + list);
//                return list;
//        }


        @GetMapping("/rank")
       public List<ReviewRankDTO> axiosReviewRank(ReviewRankDTO dto){

                List<ReviewRankDTO> rankingList = service.getReviewRankingInfo(dto);

                return  rankingList;
        }

        @GetMapping("/marketrank")
        public List<MarketRankDTO> axiosMarketrank(MarketRankDTO dto){

                List<MarketRankDTO> rankingList = service.getMarketRankingInfo(dto);

               return  rankingList;
        }

}


// @RestController

//해주는게 뭐야
//        res.status(200)
//        res.body()
//        res.header()
//        res.header.content_type = 'application/json UTF-8'




package com.example.project.controller.view;

import com.example.project.dto.request.ReviewViewDTO;
import com.example.project.dto.response.market.ShopContentBoardDTO;
import com.example.project.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/content")
@SessionAttributes("user")
public class MarketController {
    private final MarketService service;


    @GetMapping("/shop-content/{market_seq}")
    public String read(@PathVariable("market_seq") Long market_seq, Model model){
        ShopContentBoardDTO board = service.getMarketInfo(market_seq);
        List<ReviewViewDTO> list = service.list(market_seq);
        String avg = service.starAVG(market_seq);
        model.addAttribute("market",board);
        model.addAttribute("list",list);
        model.addAttribute("avg",avg);

        return "board/shop-content";
    }




}

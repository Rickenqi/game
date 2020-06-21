package com.ricky.game.web.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.game.domain.Ranking;
import com.ricky.game.domain.sys.SysRanking;
import com.ricky.game.service.RankingService;
import com.ricky.game.utils.result.Result;
import com.ricky.game.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RankingController {

    @Autowired
    RankingService rankingService;

    private Gson GSON = new GsonBuilder().create();

    @GetMapping("/ranking/{page}")
    public String getRanking(@PathVariable("page") String page) {
        Result result;
        Integer num = Integer.parseInt(page);
        try{
            PageInfo<SysRanking> ranking = rankingService.pointList(num,50);
            result = Result.success(ranking);
            return GSON.toJson(result);
        } catch (DataAccessException e) {
            result = Result.failure(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR);
            return GSON.toJson(result);
        }
    }

    @PutMapping("/ranking")
    public String updateRanking(@RequestBody SysRanking rank) {
        Result result;
        System.out.println(rank);
        try{
            rankingService.insertPoints(rank);
            System.out.println(rank);
            result = Result.success(rank);
        } catch (DataAccessException e) {
            result = Result.failure(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR);
        }
        return GSON.toJson(result);
    }
}

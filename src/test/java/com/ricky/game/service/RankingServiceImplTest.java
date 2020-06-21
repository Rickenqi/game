package com.ricky.game.service;
import com.github.pagehelper.PageInfo;
import com.ricky.game.domain.sys.SysRanking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.testng.Assert.*;


@SpringBootTest
public class RankingServiceImplTest {


    @Autowired
    private RankingService rankingService;


    @Test
    public void points(){
        PageInfo<SysRanking> points = rankingService.pointList(1,10);
        System.out.println(points);

    }

    @Test
    public void updateScore(){
        rankingService.updatePoints(1003L,10L);
    }




}
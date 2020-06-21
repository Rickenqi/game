package com.ricky.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricky.game.dao.SysRankingMapper;
import com.ricky.game.domain.sys.SysRanking;
import com.ricky.game.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private SysRankingMapper sysRankingMapper;

    //查询排行榜，pagenum第几页，pagesize一页几个
    public PageInfo<SysRanking> pointList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return PageInfo.of(sysRankingMapper.findAll());
    }

    //更新得分榜信息
    public void updatePoints(Long id, Long score){
        sysRankingMapper.updateScore(id,score);
    }

    //新建得分榜
    public void insertPoints(SysRanking sysRanking){
        sysRankingMapper.insert(sysRanking);
    }


}



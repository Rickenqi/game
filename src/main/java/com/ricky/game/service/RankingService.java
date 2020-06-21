package com.ricky.game.service;

        import com.github.pagehelper.PageInfo;
        import com.ricky.game.domain.sys.SysRanking;

        import java.util.List;

public interface RankingService {

    PageInfo<SysRanking> pointList(int pageNum, int pageSize);

    void updatePoints(Long id, Long score);

    void insertPoints(SysRanking sysRanking);

}

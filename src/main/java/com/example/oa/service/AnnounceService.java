package com.example.oa.service;

import com.example.oa.po.Announce;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AnnounceService {
    public List<Announce> queryAnnounceList(@Param("title")String title,
                                            @Param("time1") Date time1,
                                            @Param("time2") Date time2,
                                            @Param("pageNumber")int pageNumber,
                                            @Param("pageSize")int pageSize);
    int countAnnounce();
    Announce lookAnnounceById(@Param("id")int id);
    void addAnnounce(Announce announce);
}

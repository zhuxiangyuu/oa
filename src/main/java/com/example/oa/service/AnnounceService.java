package com.example.oa.service;

import com.example.oa.po.Announce;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AnnounceService {
    public List<Announce> queryAnnounceList(String title,
                                             Date time1,
                                             Date time2,
                                            int pageNumber,
                                            int pageSize
    );
    int countAnnounce();

    Announce lookAnnounceById(int id);

    int addAnnounce(Announce announce);

    int deleteAnnounceById(int id);

    int updateByPrimaryKeySelective(Announce record);

    public List<Announce> queryAnnounceListByState(String title,
                                            Date time1,
                                            Date time2,
                                            int pageNumber,
                                            int pageSize,
                                                   int state

    );
}

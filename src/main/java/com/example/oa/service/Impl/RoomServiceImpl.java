package com.example.oa.service.Impl;

import com.example.oa.mapper.RoomMapper;
import com.example.oa.po.Room;
import com.example.oa.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    RoomMapper roomMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Room record) {
        return 0;
    }

    @Override
    public int insertSelective(Room record) {
        return roomMapper.insertSelective(record);
    }

    @Override
    public Room selectByPrimaryKey(Integer id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Room record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Room record) {
        return 0;
    }


    @Override
    public int countRoom() {
        return roomMapper.countRoom();
    }

    @Override
    public String queryRoomByName(String name) {
        if(roomMapper.queryRoomByName(name)!=null){
            return "false";
        }else{
            return "true";
        }
    }

    @Override
    public List<Room> queryRoomList(int pageNumber, int pageSize) {
        return roomMapper.queryRoomList(pageNumber,pageSize);
    }
}

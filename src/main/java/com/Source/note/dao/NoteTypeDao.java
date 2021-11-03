package com.Source.note.dao;

import com.Source.note.po.NoteType;

import java.util.ArrayList;
import java.util.List;


public class NoteTypeDao {
    /**
     * 通过用户ID查询
     * @param userId
     * @return
     */
    public List<NoteType> findTypeListByUserId(Integer userId){
        String sql="select typeId,typeName,userId from tb_note_type where userId=?";
        //设置参数列表
        List<Object> params =new ArrayList<>();

        params.add(userId);
        //调用BaseDao查询方法
        List<NoteType> list =BaseDao.queryRows(sql,params,NoteType.class);
        //返回集合
        return list;
    }



}

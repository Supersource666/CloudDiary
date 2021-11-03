package com.Source.note.service;

import com.Source.note.dao.NoteTypeDao;
import com.Source.note.po.NoteType;

import java.util.List;

public class NoteTypeService {
    private NoteTypeDao noteTypeDao=new NoteTypeDao();

    /**
     * 查询类型列表
     * @param userId
     * @return
     */
    public List<NoteType>findTypeLists(Integer userId){
        List<NoteType> typeList=noteTypeDao.findTypeListByUserId(userId);
        return typeList;
    }
}

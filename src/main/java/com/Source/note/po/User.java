package com.Source.note.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer userId;
    private  String userName;
    private  String upwd;
    private String head;
    private  String nick;
    private String mood;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

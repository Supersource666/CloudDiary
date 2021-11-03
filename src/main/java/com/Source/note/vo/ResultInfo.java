package com.Source.note.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回封装结果
 *  提示信息
 *  错误码
 *      0-失败 1-成功
 *   返回的对象（字符串、JavaBean、集合、Mapper等）
 */
@Getter
@Setter
public class ResultInfo<T> {
    private Integer code;
    private  String msg;
    private  T result;

}

package com.jingdianjichi.subject.common.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * 分页请求实体
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Data
public class PageInfo implements Serializable {
//当前页码默认为1
    private Integer pageNo = 1;
//每页条数
    private Integer pageSize = 20;
//校验页码是否合法
    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }
//校验每页条数是否合法
    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}

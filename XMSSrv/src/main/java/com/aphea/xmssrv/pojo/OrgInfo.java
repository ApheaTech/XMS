package com.aphea.xmssrv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 9:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgInfo {
    private int id;
    private Date createTime;
    private Date updateTime;
    private int deleted;
    private String fullName;
    private String parentId;
}

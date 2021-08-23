package com.aphea.xmssrv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 8:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private Date createTime;
    private Date updateTime;
    private int deleted;
    private String account;
    private String fullName;
    private int orgId;
    private String phone;
    private int gender;
    private String password;
}

package com.aphea.xmssrv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/22 9:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO extends UserInfo{
    private String orgName;
}

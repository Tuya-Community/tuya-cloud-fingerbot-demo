package com.tuya.cloud.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jamesmsw
 * @date 2021/3/24 8:09 下午
 */
@Data
public class FigerbotMessage implements Serializable {

    private String data;
    private Integer protocol;
    private String pv;
    private String sign;
    private Long t;
}

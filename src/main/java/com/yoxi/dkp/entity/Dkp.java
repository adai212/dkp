package com.yoxi.dkp.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Dkp {

    private int id;
    private String name;
    private String union;
    private String job;
    private String dkp;
    private String history;
    private String tier;
}

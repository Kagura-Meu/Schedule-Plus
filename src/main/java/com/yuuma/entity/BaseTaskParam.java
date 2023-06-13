package com.yuuma.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseTaskParam implements Serializable {

    private String taskName;

    private String cron;

    private Boolean isActive;
}

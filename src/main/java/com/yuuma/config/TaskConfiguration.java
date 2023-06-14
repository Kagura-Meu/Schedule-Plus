package com.yuuma.config;

import com.yuuma.entity.BaseTaskParam;
import lombok.Data;

@Data
public abstract class TaskConfiguration<T extends BaseTaskParam> {

    private T param;

    TaskConfiguration(T param){
        this.param = param;
    }

    protected abstract void saveTaskParam();

    protected abstract void updateTaskParam();

    protected abstract T getTaskParam();

}

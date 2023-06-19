package com.yuuma.config;

import com.yuuma.entity.BaseTaskParam;
import lombok.Data;

public abstract class TaskConfiguration<T extends BaseTaskParam> {


    public abstract void saveTaskParam(T t);

    public abstract void updateTaskParam(T t);

    public abstract T getTaskParam(T t);

}

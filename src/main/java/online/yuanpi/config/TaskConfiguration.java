package online.yuanpi.config;

import online.yuanpi.entity.BaseTaskParam;

public abstract class TaskConfiguration<T extends BaseTaskParam> {


    public abstract void saveTaskParam(T t);

    public abstract void updateTaskParam(T t);

    public abstract T getTaskParam(T t);

}

package com.yuuma.action;

import com.yuuma.config.TaskConfiguration;
import com.yuuma.entity.BaseTaskParam;
import lombok.Getter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Getter
@EnableScheduling
public abstract class SchedulePlusAction< T extends BaseTaskParam> implements SchedulingConfigurer {

    protected TaskConfiguration<T> taskConfiguration;
    protected T param;

    //注入任务属性对象
    protected abstract void setParam(T param);

    //注入任务属性配置修改器
    protected abstract void setTaskConfiguration(TaskConfiguration<T> taskConfiguration);

    //定时任务主体
    protected abstract void action();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask( this::action, triggerContext -> {
            T t = taskConfiguration.getTaskParam(param);
            return new CronTrigger(t.getCron()).nextExecutionTime(triggerContext);
        });
    }
}

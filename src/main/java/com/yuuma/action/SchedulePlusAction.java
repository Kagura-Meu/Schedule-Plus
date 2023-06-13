package com.yuuma.action;

import com.yuuma.config.TaskConfiguration;
import com.yuuma.entity.BaseTaskParam;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

public abstract class SchedulePlusAction< T extends BaseTaskParam> implements SchedulingConfigurer {

//    protected T t;
    private TaskConfiguration<T> taskConfiguration;


//    protected abstract void setT(T t);

    protected abstract void setTaskConfiguration();

    protected abstract void action();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask( this::action, triggerContext -> {
            T t = taskConfiguration.getParam();
            return new CronTrigger(t.getCron()).nextExecutionTime(triggerContext);
        });
    }
}

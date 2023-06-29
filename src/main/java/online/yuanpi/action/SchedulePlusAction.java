package online.yuanpi.action;

import online.yuanpi.config.TaskConfiguration;
import online.yuanpi.entity.BaseTaskParam;
import lombok.Getter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Getter
@EnableScheduling
public abstract class SchedulePlusAction< T extends BaseTaskParam> implements SchedulingConfigurer {

    private TaskConfiguration<T> taskConfiguration;
    private T param;

    //注入任务属性对象
    protected abstract T setParam();

    //注入任务属性配置修改器
    protected abstract TaskConfiguration<T> setTaskConfiguration();

    //定时任务主体
    protected abstract void action();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask( this::action, triggerContext -> {
            T t = getTaskConfiguration().getTaskParam(getParam());
            return new CronTrigger(t.getCron()).nextExecutionTime(triggerContext);
        });
    }
}

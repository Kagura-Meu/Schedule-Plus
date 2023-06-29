package online.yuanpi.entity;

import lombok.Data;
import org.junit.platform.commons.util.StringUtils;

import java.io.Serializable;

@Data
public class BaseTaskParam implements Serializable {

    private String taskName;

    private String cron;

    private Boolean isActive;

    public void requireTaskNameCheck(){
        if (StringUtils.isBlank(taskName)){
            throw new NullPointerException("定时任务名称不能为空");
        }
    }

    public void requireParamCheck(){
        if (StringUtils.isBlank(taskName) || StringUtils.isBlank(cron) || isActive == null){
            throw new NullPointerException("定时任务基础配置属性不能为有空");
        }
    }

    public void fillNullValueFromSource(BaseTaskParam source){
        if (StringUtils.isBlank(this.taskName)){
            this.taskName = source.getTaskName();
        }
        if (StringUtils.isBlank(this.cron)){
            this.cron = source.getCron();
        }
        if (this.isActive == null){
            this.isActive = source.getIsActive();
        }
    }
}

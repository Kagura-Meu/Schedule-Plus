package online.yuanpi.action;

import com.yuuma.action.SchedulePlusAction;
import com.yuuma.config.SimpleRedisTaskConfiguration;
import com.yuuma.config.TaskConfiguration;
import online.yuanpi.config.TaskRedisConfig;
import online.yuanpi.param.TaskParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class TestAction01 extends SchedulePlusAction<TaskParam> {

    @Autowired
    private TaskParam param;

    @Autowired
    private TaskRedisConfig taskRedisConfig;

    @Override
    protected TaskParam setParam() {
        return param;
    }

    @Override
    protected TaskConfiguration<TaskParam> setTaskConfiguration() {
        return taskRedisConfig;
    }

    @Override
    protected void action() {

    }
}

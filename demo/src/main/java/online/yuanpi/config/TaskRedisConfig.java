package online.yuanpi.config;

import com.yuuma.config.SimpleRedisTaskConfiguration;
import online.yuanpi.param.TaskParam;
import online.yuanpi.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unchecked")
public class TaskRedisConfig extends SimpleRedisTaskConfiguration<TaskParam> {

    TaskRedisConfig(){
        super((RedisTemplate<String, Object>) ApplicationContextUtil.getBean("redisTemplate"));
    }

}

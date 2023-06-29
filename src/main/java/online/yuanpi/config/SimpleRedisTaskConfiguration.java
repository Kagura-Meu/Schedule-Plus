package online.yuanpi.config;

import online.yuanpi.entity.BaseTaskParam;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 通过redis实现最基础的任务配置属性的增查改
 * @param <T> BaseTaskParam的子类
 */
@Getter(value = AccessLevel.PRIVATE)
@SuppressWarnings("unchecked")
public class SimpleRedisTaskConfiguration<T extends BaseTaskParam> extends TaskConfiguration<T>{

    private static final String SCHEDULE_PARAM_KEY = "schedule_param_key";

    private final RedisTemplate<String,Object> redisTemplate;


    public SimpleRedisTaskConfiguration(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveTaskParam(T t) {
        nullParamObjectCheck(t);
        t.requireParamCheck();
        redisTemplate.opsForHash().put(SCHEDULE_PARAM_KEY, t.getTaskName(), t);
    }

    @Override
    public void updateTaskParam(T t) {
        nullParamObjectCheck(t);
        t.requireTaskNameCheck();
        T sourceParam = this.getTaskParam(t);
        t.fillNullValueFromSource(sourceParam);
        redisTemplate.opsForHash().put(SCHEDULE_PARAM_KEY, t.getTaskName(), t);
    }

    @Override
    public T getTaskParam(T t) {
        nullParamObjectCheck(t);
        t.requireTaskNameCheck();
        return (T) redisTemplate.opsForHash().get(SCHEDULE_PARAM_KEY, t.getTaskName());
    }

    private void nullParamObjectCheck(T t){
        if (t == null){
            throw new NullPointerException("任务配置属性对象不能为空");
        }
    }



}

package online.yuanpi.param;

import com.yuuma.entity.BaseTaskParam;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "task")
public class TaskParam extends BaseTaskParam {
}

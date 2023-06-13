package com.yuuma.config;

import com.yuuma.entity.BaseTaskParam;

public interface TaskConfiguration<T extends BaseTaskParam> {

    void paramInitialize();

    void saveParam();

    void updateParam();

    T getParam();

}

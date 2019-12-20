package cn.wxingzou.conditionflow;

import cn.wxingzou.conditionflow.config.ConditionConfig;
import cn.wxingzou.conditionflow.core.BeanFactory;
import cn.wxingzou.conditionflow.core.ConfigableConditionFlowTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/14 10:51
 **/
@Configuration
@ConditionalOnBean(value = BeanFactoryImpl.class, name = "conditionConfigs")
public class ConditionFlowEngineAutoConfiguration {

    @Autowired
    private List<ConditionConfig> conditionConfigs;
    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public ConfigableConditionFlowTemplate flowTemplate() {
        return new ConfigableConditionFlowTemplate(conditionConfigs, beanFactory);
    }
}

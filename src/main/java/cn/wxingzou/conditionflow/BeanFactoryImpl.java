package cn.wxingzou.conditionflow;

import cn.wxingzou.conditionflow.core.BeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaolin
 * @version 1.0
 * @date 2019/11/14 11:42
 **/
@Component
public class BeanFactoryImpl implements ApplicationContextAware, BeanFactory {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) {
        return applicationContext.getBean(s, aClass);
    }
}

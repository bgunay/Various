package com.github.pnowy.various.di.factory;

import org.springframework.beans.factory.FactoryBean;
import com.github.pnowy.various.di.bean.SampleBean;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 *         Date: 2015-04-28 20:26
 */
public class SampleBeanFactory implements FactoryBean<SampleBean> {

    @Override
    public SampleBean getObject() throws Exception {
        return new SampleBean();
    }

    @Override
    public Class<?> getObjectType() {
        return SampleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

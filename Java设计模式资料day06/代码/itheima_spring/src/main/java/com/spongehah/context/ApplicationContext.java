package com.spongehah.context;

import com.spongehah.beans.factory.BeanFactory;

public interface ApplicationContext extends BeanFactory {
    
    void refresh() throws Exception;
}

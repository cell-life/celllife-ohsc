package org.celllife.ohsc.framework.smooks;

import org.milyn.scribe.register.DaoRegister;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 11h26
 */
public class SpringRepositoryRegister implements DaoRegister<Repository>, InitializingBean {

    private Map<String, Repository> repositories;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Repository getDefaultDao() {
        return null;
    }

    @Override
    public Repository getDao(String name) {
        return repositories.get(name);
    }

    @Override
    public void returnDao(Repository dao) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
         this.repositories = applicationContext.getBeansOfType(Repository.class);
    }
}

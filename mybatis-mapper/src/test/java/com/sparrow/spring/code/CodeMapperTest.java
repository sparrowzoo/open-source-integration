package com.sparrow.spring.code;

import com.sparrow.spring.dao.CodeDAO;
import com.sparrow.spring.mybatis.MybatisEntityManager;
import com.sparrow.spring.po.Code;
import com.sparrow.support.db.UniqueKeyCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CodeMapperTest {
    @Autowired
    private CodeDAO codeDao;

    @Test
    public void codeInsertTest() {
        codeDao.insert(new Code("name", "parent_uuid", "code"));
    }

    @Test
    public void codeGetEntityByUniqueTest() {
        Code code = codeDao.getEntityByUnique(UniqueKeyCriteria.createUniqueCriteria("f0416812-baf1-11e8-9148-8c1645ace82e", "uuid"));
        System.out.println(code.getCode());
    }

    @Test
    public void codeGetEntityTest() {
        Code code = codeDao.getEntity("f0416812-baf1-11e8-9148-8c1645ace82e");
        System.out.println(code.getCode());
        String ddl = new MybatisEntityManager(Code.class).getCreateDDL();
        System.out.println(ddl);
    }
}

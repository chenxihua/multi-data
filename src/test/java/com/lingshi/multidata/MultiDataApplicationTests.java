package com.lingshi.multidata;

import com.lingshi.multidata.master.pojo.MasterUser;
import com.lingshi.multidata.master.service.MasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDataApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MultiDataApplicationTests.class);

    @Autowired
    MasterService masterService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAdd(){
        MasterUser masterUser = new MasterUser();
        masterUser.setUsername("chenxihua");
        masterUser.setPass("123456");
        masterUser.setAge(11);
        masterUser.setDesction("程序员");

        boolean add = masterService.add(masterUser);
        logger.warn("{}", add);
    }

}

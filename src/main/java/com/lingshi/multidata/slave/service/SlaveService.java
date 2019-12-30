package com.lingshi.multidata.slave.service;

import com.lingshi.multidata.slave.dao.SlaveRepository;
import com.lingshi.multidata.slave.pojo.SlaveUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: SlaveService
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/17 14:25
 **/
@Service
public class SlaveService {

    private static final Logger logger = LoggerFactory.getLogger(SlaveService.class);


    @Autowired
    SlaveRepository slaveRepository;


    /**
     * 查询所有
     * @return
     */
    public List<SlaveUser> search(){
        logger.warn("来到的是slave查询。。。");
        return slaveRepository.findAll();
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    public SlaveUser searchById(Integer id){
        Optional<SlaveUser> byId = slaveRepository.findById(id);
        if (byId.isPresent()){
            SlaveUser slaveUser = byId.get();
            return slaveUser;
        }
        return null;
    }


    /**
     * 第二个数据库也进行插入，查看事务问题
     * @param slaveUser
     * @return
     */
    @Transactional(value = "slaveTransactionManager", rollbackFor = Exception.class)
    public boolean saveSlaveBean(SlaveUser slaveUser){
        SlaveUser save = slaveRepository.save(slaveUser);
        if(save!=null){
            return true;
        }
        return false;
    }


}

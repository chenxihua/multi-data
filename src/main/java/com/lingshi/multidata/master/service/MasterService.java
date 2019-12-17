package com.lingshi.multidata.master.service;

import com.lingshi.multidata.master.dao.MasterRepository;
import com.lingshi.multidata.master.pojo.MasterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MasterService
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/17 14:24
 **/
@Service
public class MasterService {

    private static final Logger logger = LoggerFactory.getLogger(MasterService.class);

    @Autowired
    MasterRepository masterRepository;


    /**
     * 插入
     * @param masterUser
     * @return
     */
    public boolean add(MasterUser masterUser){
        logger.warn("master --> 插入");
        MasterUser save = masterRepository.save(masterUser);
        if (save != null){
            return true;
        }
        return false;
    }

    /**
     * 修改
     * @param masterUser
     * @return
     */
    public boolean update(MasterUser masterUser){
        logger.warn("master --> 修改");
        MasterUser saveAndFlush = masterRepository.saveAndFlush(masterUser);
        if (saveAndFlush != null){
            return true;
        }
        return false;
    }


    /**
     * 删除
     * @param id
     */
    public void delete(Integer id){
        logger.warn("master --> 删除");
        masterRepository.deleteById(id);
    }

}

package com.lingshi.multidata.controller;

import com.lingshi.multidata.master.pojo.MasterUser;
import com.lingshi.multidata.master.service.MasterService;
import com.lingshi.multidata.slave.pojo.SlaveUser;
import com.lingshi.multidata.slave.service.SlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/show")
public class MultiSouceController {

    @Autowired
    MasterService masterService;

    @Autowired
    SlaveService slaveService;


    /**
     * 新增
     * @param masterUser
     * @return
     */
    @PostMapping(value = "add", produces = "application/json;charset=UTF-8")
    public Map<String, Object> add(@RequestBody MasterUser masterUser){
        Map<String, Object> result = new HashMap<>(2);
        boolean add = masterService.add(masterUser);
        result.put("code", 0);
        result.put("data", add);
        return result;
    }


    /**
     * 更新
     * @param masterUser
     * @return
     */
    @PutMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Map<String, Object> update(@RequestBody MasterUser masterUser){
        Map<String, Object> result = new HashMap<>(2);
        boolean update = masterService.update(masterUser);
        result.put("code", 0);
        result.put("data", update);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public Map<String, Object> delete(@RequestParam Integer id){
        masterService.delete(id);
        Map<String, Object> result = new HashMap<>(2);
        result.put("code", 0);
        result.put("data", "删除成功");
        return result;
    }


    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/findAll")
    public Map<String, Object> findAll(){
        Map<String, Object> result = new HashMap<>(2);
        List<SlaveUser> search = slaveService.search();
        result.put("code", 0);
        result.put("data", search);
        return result;
    }


    /**
     * 查询单个
     * @param id
     * @return
     */
    @GetMapping(value = "/findById")
    public Map<String, Object> findById(@RequestParam Integer id){
        Map<String, Object> result = new HashMap<>(2);
        SlaveUser slaveUser = slaveService.searchById(id);
        result.put("code", 0);
        result.put("data", slaveUser);
        return result;
    }


    /**
     * 用于第二个数据库的保存问题
     * @param slaveUser
     * @return
     */
    @PostMapping(value = "saveSlave")
    public Map<String, Object> saveSlave(@RequestBody SlaveUser slaveUser){
        Map<String, Object> result = new HashMap<>(2);
        boolean saveSlaveBean = slaveService.saveSlaveBean(slaveUser);
        result.put("code", 0);
        result.put("data", saveSlaveBean);
        return result;
    }





}

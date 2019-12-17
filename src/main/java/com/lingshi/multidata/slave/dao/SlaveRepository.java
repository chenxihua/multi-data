package com.lingshi.multidata.slave.dao;


import com.lingshi.multidata.slave.pojo.SlaveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlaveRepository extends JpaRepository<SlaveUser, Integer> {
}

package com.lingshi.multidata.master.dao;

import com.lingshi.multidata.master.pojo.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<MasterUser, Integer> {
}

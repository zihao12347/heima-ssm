package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;

import java.util.List;

public interface TravellerDao {
    public List<Traveller> findByOid(String id);
}

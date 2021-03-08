package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

//给bean改名为alphaHibernate，getBean可以使用这个新名字获取bean
@Repository("alphaHibernate")
public class AlphaHibernateImpl implements AlphaDao {

    @Override
    public String select() {
        return "Hibernate";
    }
}

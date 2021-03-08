package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Primary
//@Scope("prototype")
public class AlphaDaoMyBatisImpl implements AlphaDao{

    AlphaDaoMyBatisImpl(){
        System.out.println("AlphaMyBatis constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("AlphaMyBatis post constructor");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("AlphaMyBatis pre destroy");
    }

    @Override
    public String select() {
        return "MyBatis";
    }
}

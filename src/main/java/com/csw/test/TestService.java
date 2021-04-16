package com.csw.test;

import com.csw.entity.User2;
import com.csw.service.User2Service;
import com.csw.service.User2ServiceImpl;

/**
 * Created by Administrator on 2019/10/15.
 */
public class TestService {
    public static void main(String[] args) {
        User2Service us=new User2ServiceImpl();
        User2 uu=us.queryBy("qqq");
        System.out.println(uu);
    }

}

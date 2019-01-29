package com.zy.protobuf.test;

import com.zy.protobuf.entity.Group;
import com.zy.protobuf.entity.User;
import com.zy.protobuf.util.ProtostuffUtils;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        //创建一个user对象
        User user = new User();
        user.setName("张三");
        user.setId("1");
        user.setAge(20);
        user.setDesc("programmer");
        Group group = new Group();
        group.setId("1");
        group.setName("分组1");
        group.setUser(user);
        //使用ProtostuffUtils序列化
        byte[] data = ProtostuffUtils.serialize(group);
        System.out.println("序列化后：" + Arrays.toString(data));
        Group result = ProtostuffUtils.deserialize(data, Group.class);
        System.out.println("反序列化后：" + result.toString());
    }

}

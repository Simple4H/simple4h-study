package com.simple4h.sample.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.simple4h.sample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 根据字段排序
 *
 * @author Simple4H
 */
@Slf4j
public class SortBySelectDemo {

    public static void main(String[] args) throws Exception {
        String select = "id";


        User u1 = new User();
        u1.setId(1);
        User u2 = new User();
        u2.setId(32);
        User u3 = new User();
        u3.setId(21);
        User u4 = new User();
        u4.setId(113);
        User u5 = new User();
        u5.setId(8);
        List<User> users = Lists.newArrayList(u1, u2, u3, u4, u5);


        sortObjectList(users, select, false);
        System.out.println(JSON.toJSONString(users));

//        users.sort((o1, o2) -> {
//            try {
//                Method getMethod = getGetMethod(new User(), select);
//                return Math.toIntExact((Integer) getMethod.invoke(o1) - (Integer) getMethod.invoke(o2));
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//        System.out.println(JSON.toJSONString(users));
    }


    public static Method getGetMethod(Object ob, String name) {
        Method[] m = ob.getClass().getMethods();
        for (Method method : m) {
            if (("get" + name).equalsIgnoreCase(method.getName())) {
                return method;
            }
        }
        throw new RuntimeException("方法异常");
    }

    public static <T> void sortObjectList(List<T> list, String fieldName, boolean asc) {
        if (CollectionUtils.isEmpty(list) || StringUtils.isBlank(fieldName)) {
            return;
        }
        try {
            list.sort((x, y) -> {
                try {
                    Method method;
                    String fieldNameTmp = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
                    try {
                        method = x.getClass().getDeclaredMethod("get" + fieldNameTmp);
                    } catch (NoSuchMethodException e) {
                        method = x.getClass().getDeclaredMethod("is" + fieldNameTmp);
                    }
                    Object resultX = method.invoke(x);
                    Object resultY = method.invoke(y);
                    int result;
                    if (resultX == null && resultY != null) {//null值往后靠
                        result = 1;
                    } else if (resultY == null) {
                        result = -1;
                    } else if (resultX instanceof Comparable) {
                        result = ((Comparable<Object>) resultX).compareTo(resultY);
                    } else {
                        result = resultX.toString().compareTo(resultY.toString());
                    }
                    return asc ? result : -result;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            log.error("排序异常", e);
        }
    }
}

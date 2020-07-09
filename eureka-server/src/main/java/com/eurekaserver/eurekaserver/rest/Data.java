package com.eurekaserver.eurekaserver.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Data {
    public static Map<String, String> map = new HashMap<>();

    public void write(String i) {
        String name = Thread.currentThread().getName();
        //System.out.println(name + " start write " + i);
        //System.out.println(name + " start write " + i);
        synchronized (this) {
            map.put(i, i);
            System.out.println(name + " write size " + map.size());
        }
    }

    public List<String> read() {
        String name = Thread.currentThread().getName();
        Map<String, String> map0 = new HashMap<>();
        List<String> list = new ArrayList<>();
        synchronized (this) {
            try {
                map0 = map;
                Thread.sleep(5000);
                list = new ArrayList<>(map0.keySet());
                System.out.println(name + " read size:" + map.size());
                map = new HashMap<>();

            }
            catch (Exception e) {

            }
        }
        return list;
    }


    public void otherMethod() {
        System.out.println("otherMethod  run   ---------------------");
    }



}

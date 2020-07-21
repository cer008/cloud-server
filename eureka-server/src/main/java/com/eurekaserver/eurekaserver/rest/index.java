package com.eurekaserver.eurekaserver.rest;

import com.eurekaserver.eurekaserver.vo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class index {
    @RequestMapping("/index")
    public String index() {
        return "lcj";
    }


    @Test
    public void test() {
        // Definition for a Node.
        class Node {
            public int val;
            public List<Node> children;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, List<Node> _children) {
                val = _val;
                children = _children;
            }
        }

        class Solution {
            List<Node> result = new ArrayList<>();

            public void preorder(Node node) {
                if (node == null) {
                    return;
                }
                findChildren(node, result);
            }

            public void findChildren(Node node, List<Node> result) {
                result.add(node);
            }


        }
    }

    @Autowired
    private Data date;


    public static class TestData {
        volatile int num = 0;
        public void updateNum(){
            num = 1;
        }
    }

    public static void main(String[] args) {
        TestData testData = new TestData();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ChildThread num-->" + testData.num);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testData.updateNum();
                System.out.println(Thread.currentThread().getName() + " ChildThread update num-->" + testData.num);
            }
        });
        thread.start();

        while (testData.num == 0){
//            try {
//                Thread.sleep(1000);
//                System.out.println("0"+"---"+Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(testData.num+"---"+Thread.currentThread().getName());
                //System.out.println("testData.num"+testData.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @PostConstruct
    void init() {
        User user = new User();
        new Thread(() -> {
            user.setUserName("123");
            //read();
        }).start();

        try {
            Thread.sleep(10000);
            while (user.getUserName() == null){
                System.out.println("-----");
            }
            System.out.println(user);
        }catch (Exception e){

        }



//        new Thread(() -> {
//            write();
//        }).start();


//        new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(100);
//                    date.otherMethod();
//                }
//                catch (Exception e) {
//
//                }
//
//            }
//
//        }).start();

    }

    void write() {
        while (true) {
            try {

                for (int i = 0; i < 10000; i++) {
                    Thread.sleep(100);
                    date.write(String.valueOf(i));
                }

            }
            catch (Exception e) {

            }

        }
    }

    void read() {
        while (true) {
            try {
                Thread.sleep(500);
                List<String> list = date.read();
            }
            catch (Exception e) {

            }

        }
    }

}

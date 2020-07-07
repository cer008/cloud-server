package com.eurekaserver.eurekaserver.rest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class index {
    @RequestMapping("/index")
    public String  index (){
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
                if(node == null){
                    return;
                }
                findChildren(node,result);
            }

            public void findChildren(Node node,List<Node> result){
                result.add(node);
            }


        }
    }
}

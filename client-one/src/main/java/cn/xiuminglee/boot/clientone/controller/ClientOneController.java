package cn.xiuminglee.boot.clientone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiuming Lee
 * @description
 */
@RestController
@RequestMapping("client-one")
public class ClientOneController {

    @RequestMapping("test")
    public String test(){
        return "我是client one test()方法返回!!";
    }
}

/**
 * Date:     2018/6/2023:11
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudfeign.service;

import com.zhou.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 2018/6/20  23:11
 * created by zhoumb
 */
@FeignClient("hello-service")  //you will use server name
public interface HelloService {

    @RequestMapping("/index") //no param
    String hello();

    @GetMapping(value = "hello1") //hava one param
    String hello(@RequestParam(value = "name") String name);

    @GetMapping(value = "hello2")
    User hello(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age);

    @GetMapping(value = "/hello3")
    String hello(@RequestBody User user);

    @RequestMapping(value = "/delay",method = RequestMethod.GET)
    String delay();
}

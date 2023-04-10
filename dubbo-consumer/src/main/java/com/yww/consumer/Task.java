package com.yww.consumer;

import com.yww.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 *      消费端请求任务,除了springboot启动类外，还可以基于 CommandLineRunner去创建
 * </p>
 *
 * @author yww
 * @since 2023/4/10
 */
@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) {
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

}

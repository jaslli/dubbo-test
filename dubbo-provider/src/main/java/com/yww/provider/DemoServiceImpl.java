package com.yww.provider;

import com.yww.demo.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 *      服务接口的远端实现类
 * </p>
 *
 * @author yww
 * @since 2023/4/10
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello  " + name;
    }
}

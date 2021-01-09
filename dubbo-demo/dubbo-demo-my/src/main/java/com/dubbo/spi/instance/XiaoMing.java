package com.dubbo.spi.instance;

import com.dubbo.spi.api.Human;
import org.apache.dubbo.common.URL;

/**
 * @author lla, 2021/1/4  9:09
 */
public class XiaoMing implements Human {

    @Override
    public void move(URL url) {
        System.out.println("xiaoming moving...");
    }
}

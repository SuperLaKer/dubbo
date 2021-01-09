package com.dubbo.spi.instance;

import com.dubbo.spi.api.Car;
import org.apache.dubbo.common.URL;

/**
 * @author lla, 2021/1/4  9:09
 */
public class BenCi implements Car {
    @Override
    public void move(URL url) {
        System.out.println("benci moving...");
    }
}

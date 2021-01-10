package com.dubbo.spi.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lla, 2021/1/4  9:04
 */
@SPI
public interface Car {

    @Adaptive("carName")
    void move(URL url);
}

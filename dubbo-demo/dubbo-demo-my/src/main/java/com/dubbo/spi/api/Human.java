package com.dubbo.spi.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lla, 2021/1/4  9:06
 */
@SPI
public interface Human {
    void move(URL url);
}

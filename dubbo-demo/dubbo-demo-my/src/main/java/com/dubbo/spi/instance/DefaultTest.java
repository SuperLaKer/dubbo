package com.dubbo.spi.instance;

import com.dubbo.spi.api.DefaultAdaptive;
import org.apache.dubbo.common.extension.Adaptive;

@Adaptive
public class DefaultTest implements DefaultAdaptive {
    @Override
    public void say() {
        System.out.println("DefaultAdaptive...DefaultTest");
    }
}

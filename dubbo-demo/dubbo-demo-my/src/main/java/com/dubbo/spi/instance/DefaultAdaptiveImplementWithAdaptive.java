package com.dubbo.spi.instance;

import com.dubbo.spi.api.DefaultAdaptive;
import org.apache.dubbo.common.extension.Adaptive;

@Adaptive
public class DefaultAdaptiveImplementWithAdaptive implements DefaultAdaptive {
    @Override
    public void say() {
        System.out.println("这是Car的默认实现类..."+this.getClass().getSimpleName());
    }
}

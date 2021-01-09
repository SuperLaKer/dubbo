package com.dubbo.spi.instance;

import com.dubbo.spi.api.Car;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class Car$Adaptive implements Car {
    public void move(URL url) {
        if (url == null) throw new IllegalArgumentException("url == null");
        String extName = url.getParameter("carName");
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car extension = extensionLoader.getExtension(extName);
        extension.move(url);
    }
}

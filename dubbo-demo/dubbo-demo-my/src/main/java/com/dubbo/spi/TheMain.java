package com.dubbo.spi;

import com.dubbo.spi.api.Car;
import com.dubbo.spi.api.Human;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lla, 2021/1/4  9:10
 */
public class TheMain {
    public static void main(String[] args) {
        autoDI("jayChou", "ae86");
        // getCar("ae86");
        // getHuman("xiaoming");
    }

    private static void autoDI(String humanName, String carName){
        Map<String, String> map = new HashMap<>();
        map.put("carName", carName);
        URL url = new URL("", "", 1, map);

        ExtensionLoader<Human> extensionLoader = ExtensionLoader
                .getExtensionLoader(Human.class);

        // human对象有个Car car属性，这个属性是自适应属性
        // 属性根据carName，获取Car的extensionLoader然后获取具体的Car对象
        Human human = extensionLoader.getExtension(humanName);
        // 根据carName动态注入Car的实现类
        human.move(url);
    }

    private static void getCar(String carName) {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader
                .getExtensionLoader(Car.class);
        Car ae86 = extensionLoader.getExtension(carName);
        ae86.move(null);
    }

    private static void getHuman(String humanName) {
        ExtensionLoader<Human> extensionLoader = ExtensionLoader
                .getExtensionLoader(Human.class);
        Human human = extensionLoader.getExtension(humanName);
        human.move(null);
    }
}

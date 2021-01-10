package com.dubbo.spi;

import com.dubbo.spi.api.Car;
import com.dubbo.spi.api.DefaultAdaptive;
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

    /**
     * 注解@Adaptive: 可以放到类上、接口的抽象方法上（根据URL确定使用哪个实现类）
     */
    private static void defaultExtension(){
        // TestInterface object = extensionLoader.getAdaptiveExtension()
        // object指向添加了@Adaptive注解的哪个类
    }

    private static void autoDI(String spiName, String spiFieldName){
        Map<String, String> map = new HashMap<>();
        map.put("carName", spiFieldName);
        URL url = new URL("", "", 1, map);

        ExtensionLoader<Human> extensionLoader = ExtensionLoader
                .getExtensionLoader(Human.class);

        // human对象有个Car car属性，这个属性是自适应属性
        // 属性根据carName，获取Car的extensionLoader然后获取具体的Car对象
        Human human = extensionLoader.getExtension(spiName);
        // 根据carName动态注入Car的实现类
        human.move(url);
    }


    /**
     * 使用@Adaptive修饰类：接口的默认代理实现类
     * 使用@Adaptive修饰接口方法(URL)：使用URL指定的实现类调用该方法
     */
    private static void getProxyObject(){

        // 默认提供@Adaptive修饰类
        ExtensionLoader<DefaultAdaptive> extensionLoader = ExtensionLoader.getExtensionLoader(DefaultAdaptive.class);
        DefaultAdaptive adaptiveExtension = extensionLoader.getAdaptiveExtension();
        adaptiveExtension.say();
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

package com.dubbo.spi.instance;

import com.dubbo.spi.api.Car;
import com.dubbo.spi.api.Human;
import org.apache.dubbo.common.URL;

/**
 * @author lla, 2021/1/4  9:07
 */
public class JayChou implements Human {

    Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void move(URL url) {
        System.out.println("jayChou驾驶xx..");
        car.move(url);
    }

    public JayChou() {
        System.out.println("jayChou无参构造...");
    }
}

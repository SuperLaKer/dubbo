package com.dubbo.spi.instance;

import com.dubbo.spi.api.Human;
import org.apache.dubbo.common.URL;

/**
 * @author lla, 2021/1/4  14:18
 */
public class HumanWrapper implements Human {

    Human human;

    public HumanWrapper(Human human) {
        this.human = human;
    }

    @Override
    public void move(URL url) {
        System.out.println("这是HumanWrapper类");
        human.move(url);
    }
}

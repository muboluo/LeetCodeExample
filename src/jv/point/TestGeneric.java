package jv.point;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试类
 */
class TestGeneric<T>{

    public void test1(T t) {
        //这里会报错 T 类型不能直接初始化。
        //原因就是泛型擦除
        t = new T();
    }

}

class SubTest extends TestGeneric{

    public void testSub() {
        //根据 PECS 原则，extends 只能读，不能写。
        //super 只能写，不能读。
        List<? extends TestGeneric> temp = new ArrayList<>();

        TestGeneric test = new TestGeneric();
        temp.add(test);
        temp.add(new SubTest());
        temp.add(new Object());
    }

}

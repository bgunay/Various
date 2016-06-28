package com.github.pnowy.various.annotations;

import java.lang.reflect.Method;

public class TestAnnotationParser {
    void parse(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                String info = test.info();
                System.out.println("INFO:" + info);
//				method.invoke();
            }
        }
    }

    void invokeThis(Object theObject) {
        try {
            Method[] methods = Class.forName(theObject.getClass().getName()).getMethods();
            for (Method method : methods) {
                InvokeMultiple invokeMultiple = method.getAnnotation(InvokeMultiple.class);
                if (invokeMultiple != null) {
                    int numberOfTimesToInvoke = invokeMultiple.numberOfTimesToInvoke();
                    for (int j = 0; j < numberOfTimesToInvoke; j++) {
                        method.invoke(theObject, (Object[]) null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

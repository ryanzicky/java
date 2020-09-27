package com.jvm.agent;

import java.lang.instrument.Instrumentation;

/**
 * @Author: zhourui
 * @Date: 2020-09-24 14:40
 **/
public class ObjectSizeAgent {

    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }
}

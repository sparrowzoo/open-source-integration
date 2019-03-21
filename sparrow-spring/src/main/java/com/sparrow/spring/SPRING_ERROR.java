package com.sparrow.spring;

import com.sparrow.protocol.ModuleSupport;
import com.sparrow.support.AbstractErrorSupport;

/**
 * Created by harry on 2017/6/27.
 */
public class SPRING_ERROR extends AbstractErrorSupport {

    public static SPRING_ERROR SPARROW_ERROR = new SPRING_ERROR(null, "1000", "ok");

    public SPRING_ERROR(ModuleSupport moduleSupport, String code, String message) {
        super(false, moduleSupport, code, message);
    }

//    public SPRING_ERROR(int code, String message) {
//        //super(code, message);
//    }
}

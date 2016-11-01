//package btrace;
//
//import com.sun.btrace.annotations.*;
//
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TraceObjectValue {
//
//    @OnMethod(clazz = "com.zhaming.trace.btrace.ActionObject", method = "work", location = @Location(Kind.RETURN))
//    public static void getMethodValueAndReturn(@Self com.zhaming.trace.btrace.ActionObject instance, int sleepTime, @Return int totalTime) {
//        println("call ActionObject work method:");
//        println(strcat("sleepTime", str(sleepTime)));
//        println(strcat("return total timeL", str(get(field("com.zhaming.trace.btrace.ActionObject", "totalTimes"), instance))));
//    }
//
//}
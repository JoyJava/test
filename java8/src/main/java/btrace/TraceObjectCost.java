package btrace;import static com.sun.btrace.BTraceUtils.*;import com.sun.btrace.annotations.*;@BTracepublic class TraceObjectCost {    @TLS    static long startTime;    @OnMethod(clazz = "com.zhaming.trace.btrace.ActionObject", method = "work", location = @Location(Kind.RETURN))    public static void start() {        startTime = timeMillis();    }    @OnMethod(clazz = "com.zhaming.trace.btrace.ActionObject", method = "work", location = @Location(Kind.RETURN))    public static void getMethodExecuteCost(int sleepTime,@Return int totalTime) {        String str = str(timeMillis() - startTime);        String strcat = strcat("execute work method cost:", str);        String strcat2 = strcat(strcat, " ms");        println(strcat2);    }}
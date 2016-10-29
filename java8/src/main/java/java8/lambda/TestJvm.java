package java8.lambda;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.jvmstat.monitor.*;
import sun.tools.attach.BsdVirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * User: fh
 * Date: 14-8-8
 * Time: 15:47
 */
public class TestJvm {

    // Oracle (Sun) HotSpot
    static final String YOUNG_GC_MONITOR_NAME = "sun.gc.collector.0.invocations";
    static final String FULL_GC_MONITOR_NAME = "sun.gc.collector.1.invocations";

    // Oracle (BEA) JRockit
    // static final String YOUNG_GC_MONITOR_NAME = 'jrockit.gc.latest.yc.number'
    // static final String FULL_GC_MONITOR_NAME  = 'jrockit.gc.latest.oc.number'

    public static void main(String[] args) throws Exception {
        System.out.println("jvm....");
        //获取线程ID
        MonitoredHost monitoredHost = MonitoredHost.getMonitoredHost("localhost");
        monitoredHost.activeVms().forEach((it) ->
                System.out.println("PID = " + it)
        );


        MonitoredVm monitoredVm = monitoredHost.getMonitoredVm(new VmIdentifier((String) null));
//        Monitor ygc = monitoredVm.findByName(YOUNG_GC_MONITOR_NAME);
//        Monitor fgc = monitoredVm.findByName(FULL_GC_MONITOR_NAME);
//        System.out.println(ygc.getValue());
//        System.out.println(fgc.getValue());
        monitoredVm.findByPattern(".*").forEach((Monitor it) -> {
            System.out.println(it.getName() + " = " + it.getValue());
        });

        BsdVirtualMachine vm = (BsdVirtualMachine) VirtualMachine.attach("585");
//        vm.getSystemProperties();

    }
}

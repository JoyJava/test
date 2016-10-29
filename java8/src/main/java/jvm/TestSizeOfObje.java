package jvm;

import java.lang.instrument.Instrumentation;


public class TestSizeOfObje {
	public static void premain(String agentArgs, Instrumentation inst) {
	}
	public static void main(String[] args) {
//		long objectSize = Instrumentation.getObjectSize(new Object());
		System.out.println();
	}
	

}
class A1 {
	int a = 1 ;
	long b = 2 ;
	byte c =3 ;
//	public long sizeOf(){
//		
//		//return Instrumentation.getObjectSize(this);
//	}
}

class A2 {
	long b = 2 ;
	int a = 1 ;
	byte c =3 ;
}
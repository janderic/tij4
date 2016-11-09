package com.gmail.janderic.kuk.tij4.chapter9.practice14;

public class Test {
    
    void A(InterfaceA interfaceA) {
	interfaceA.A1();
	interfaceA.A2();
    }
    void B(InterfaceB interfaceB) {
	interfaceB.B1();
	interfaceB.B2();
    }
    void C(InterfaceC interfaceC) {
	interfaceC.C1();
	interfaceC.C2();
    }
    void ABC(InterfaceABC interfaceABC) {
	interfaceABC.ABC();
    }
    
    public static void main(String[] args) {
	Sub sub = new Sub();
	Test t = new Test();
	t.A(sub);
	t.B(sub);
	t.C(sub);
	t.ABC(sub);
    }
}

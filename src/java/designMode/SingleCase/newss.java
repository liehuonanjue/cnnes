package designMode.SingleCase;

public class newss {

    public static void main(String[] args) {
        Strdent su = Strdent.getStrdent();
        Strdent su2 = Strdent.getStrdent();
        Strdent su3 = Strdent.getStrdent();
        System.out.println(su==su2);
        System.out.println(su==su3);

    }
}

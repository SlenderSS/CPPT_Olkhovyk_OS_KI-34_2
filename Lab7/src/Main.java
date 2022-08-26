

public class Main {

	public static void main(String[] args) {
		Carriege<? super Filling> carriege = new Carriege<Filling>();
        carriege.AttachCarriege(new Cargo("CargoType", 5000, 6000));
        carriege.AttachCarriege(new Cargo("CargoType2", 4000, 6000));
        carriege.AttachCarriege(new Passengers(60, 56, 80));
        Filling res = carriege.findMax();
        System.out.print("The biggest weiht is: ");
        System.out.println(res.getAllInfo());
	}

}

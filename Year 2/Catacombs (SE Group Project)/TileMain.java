public class TileMain {

	public static void main(String[] args) {

		Corner testC1 = new Corner(1, false );
		Corner testC2 = new Corner(2, true );

		System.out.println(testC1.toString());
		System.out.println(testC2.toString());

		Straight testS1 = new Straight( 3, true);
		Straight testS2 = new Straight( 4, false);

		System.out.println(testS1.toString());
		System.out.println(testS2.toString());

		T_Shape testT1 = new T_Shape( 2, true);
		T_Shape testT2 = new T_Shape( 4, false);

		System.out.println(testT1.toString());
		System.out.println(testT2.toString());





	}

}

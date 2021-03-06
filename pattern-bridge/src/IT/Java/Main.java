package IT.Java;

import IT.Java.bridge.BossCar;
import IT.Java.bridge.ElectricEngine;
import IT.Java.bridge.HybridEngine;
import IT.Java.bridge.RefinedCar;
import IT.Java.bridge.TinyCar;


public class Main {

	public static void main(String[] args) {
		RefinedCar car1 = new BossCar(new HybridEngine());
		car1.drive();
		RefinedCar car2 = new TinyCar(new ElectricEngine());
		car2.drive();
	}
}

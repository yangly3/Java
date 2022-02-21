
/**
 *20%
 */
public class RoyaltyIncome {

	protected double income;
	
	public RoyaltyIncome(double income) {
		this.income = income;
	}

	public double getTax() {
		return income * 0.2; // 
	}

}

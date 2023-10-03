package Login.GenericUtilities;

import java.util.Random;

public class JavaUtility {

	public int getRandomNum() {
		Random rndNum= new Random();
		return rndNum.nextInt(1000);
	}
}

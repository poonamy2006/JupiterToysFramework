package Jupiter.toys.utilities;

public class FloatConversion {
	
	public static Float FloatConvert(String Expected_StuffedFrog) {
		String Exp_ProductPrice= Expected_StuffedFrog.replace("$", "");
		Float Pp= Float.parseFloat(Exp_ProductPrice);
		return Pp;
		
	}

}

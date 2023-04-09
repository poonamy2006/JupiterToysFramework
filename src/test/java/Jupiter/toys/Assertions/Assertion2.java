package Jupiter.toys.Assertions;

import Jupiter.toys.utilities.LogsCapture;

public class Assertion2 {
	

	public static boolean VerifyMessages(String Expected, String Actual,String ClassName) {
		
		if(Actual.contains(Expected)) {
		
			LogsCapture.TakeLogs(ClassName, "The messages are matching...");
			return true;
		}
		else {
			
			LogsCapture.TakeLogs(ClassName, "The messages are not matching...");
			return false;
		}
				}
}




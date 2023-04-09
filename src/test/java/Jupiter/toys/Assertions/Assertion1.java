package Jupiter.toys.Assertions;

import Jupiter.toys.utilities.LogsCapture;

public class Assertion1 {
	
	
	public static boolean VerifyMessages(String Expected, String Actual,String ClassName) {
		
		if(Actual.equals(Expected)) {
			
		LogsCapture.TakeLogs(ClassName, "Testcase Passed.");
		return true;
		}
		else {
			
		LogsCapture.TakeLogs(ClassName, "Testcase failed.");
	    return false;
		}
				}
}

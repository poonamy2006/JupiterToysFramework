package Jupiter.toys.Assertions;

import Jupiter.toys.utilities.LogsCapture;

public class Assertion3 {
	
	
	public static boolean TotalAssertion(Float ActualTotal, Float ExpectedTotal,String ClassName) {
		
		if(ActualTotal.equals(ExpectedTotal)) {
		LogsCapture.TakeLogs(ClassName, "Testcase Passed.");
		return true;
		}
			else{
			LogsCapture.TakeLogs(ClassName, "Testcase failed.");
			return false;
			}
		}
		
		
	}
	
	


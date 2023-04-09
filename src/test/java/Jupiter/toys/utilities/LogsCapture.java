package Jupiter.toys.utilities;

	import org.apache.log4j.Logger;
	import org.apache.log4j.xml.DOMConfigurator;
	

	public class LogsCapture {
		
		
		public static void TakeLogs(String Classname, String message) {
			DOMConfigurator.configure("..//JupiterToys/layout.xml");
			Logger log= Logger.getLogger(Classname);
			log.info(message);
		}

	}



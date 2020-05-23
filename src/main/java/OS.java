import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class OS {
	
	SystemInfo si = new SystemInfo();
	OperatingSystem os =si.getOperatingSystem();
	
	public SystemInfo getSystem() {
		return this.si;
	}

	public OperatingSystem getOS() {
		return this.os;
	}
}

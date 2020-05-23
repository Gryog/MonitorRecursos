import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Hardware {
	
	SystemInfo si = new SystemInfo();	
	HardwareAbstractionLayer hal = si.getHardware();
	
	
	public HardwareAbstractionLayer getHW() {
		return this.hal;
	}

}

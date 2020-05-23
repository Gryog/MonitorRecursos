import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public abstract class Produto {
	
	private String modelo;
	private String fabricante;
	private String nome;
	private Software n;
	
	
	SystemInfo si = new SystemInfo();	
	HardwareAbstractionLayer hal = si.getHardware();
	OperatingSystem os =si.getOperatingSystem();
	
	public Software getmodelo(Software n) {
		return n;
	}

}

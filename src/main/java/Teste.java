import static org.junit.Assert.assertFalse;

import org.junit.Test;

import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Teste extends Software {
	@Test
	public void testPlatformEnum() {
		assertFalse(PlatformEnum.UNKNOWN.equals(SystemInfo.getCurrentPlatformEnum()));
		// Exercise the main method
		main(null);
	}

	public static void main(String[] args) {

		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		

		Software OS = new Software();
		OperatingSystem os = OS.getOperatingSystem();
		System.out.println(os);
		System.out.println(os.getBitness());
		System.out.println(os.getVersionInfo());

//		CentralProcessor cpu = hal.getProcessor();
//		GlobalMemory gm = hal.getMemory();
//		ComputerSystem cs = hal.getComputerSystem();
//		List<PowerSource> ps = hal.getPowerSources();
//		List<HWDiskStore> hd = hal.getDiskStores();
//		List<Display> pd = hal.getDisplays();
//		List<NetworkIF> ni = hal.getNetworkIFs();
//		List<GraphicsCard> gc = hal.getGraphicsCards();
//		List<UsbDevice> ud = hal.getUsbDevices(true);
//		List<SoundCard> sc = hal.getSoundCards();
//		Sensors s = hal.getSensors();

//		System.out.println(os);
//		System.out.println(cpu);
//		System.out.println();
//		System.out.println(gm);
//		System.out.println();
//		System.out.println(cs);
//		System.out.println();
//		System.out.println(ps);
//		System.out.println();
//		System.out.println(hd);
//		System.out.println();
//		System.out.println(pd);
//		System.out.println();
//		System.out.println(ni);
//		System.out.println();
//		System.out.println(gc);
//		System.out.println();
//		System.out.println(ud);
//		System.out.println();
//		System.out.println(sc);
//		System.out.println();
//		System.out.println(s);

	}
}

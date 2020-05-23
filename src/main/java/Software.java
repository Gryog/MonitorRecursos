import static oshi.util.Memoizer.memoize;

import java.util.function.Supplier;

import com.sun.jna.Platform;

import oshi.PlatformEnum;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.platform.linux.LinuxHardwareAbstractionLayer;
import oshi.hardware.platform.mac.MacHardwareAbstractionLayer;
import oshi.hardware.platform.unix.freebsd.FreeBsdHardwareAbstractionLayer;
import oshi.hardware.platform.unix.solaris.SolarisHardwareAbstractionLayer;
import oshi.hardware.platform.windows.WindowsHardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.software.os.linux.LinuxOperatingSystem;
import oshi.software.os.mac.MacOperatingSystem;
import oshi.software.os.unix.freebsd.FreeBsdOperatingSystem;
import oshi.software.os.unix.solaris.SolarisOperatingSystem;
import oshi.software.os.windows.WindowsOperatingSystem;

public class Software extends Produto{
	
    private static final PlatformEnum currentPlatformEnum;

    static {
        if (Platform.isWindows()) {
            currentPlatformEnum = PlatformEnum.WINDOWS;
        } else if (Platform.isLinux()) {
            currentPlatformEnum = PlatformEnum.LINUX;
        } else if (Platform.isMac()) {
            currentPlatformEnum = PlatformEnum.MACOSX;
        } else if (Platform.isSolaris()) {
            currentPlatformEnum = PlatformEnum.SOLARIS;
        } else if (Platform.isFreeBSD()) {
            currentPlatformEnum = PlatformEnum.FREEBSD;
        } else {
            currentPlatformEnum = PlatformEnum.UNKNOWN;
        }
    }

    private final Supplier<OperatingSystem> os = memoize(this::createOperatingSystem);

    private final Supplier<HardwareAbstractionLayer> hardware = memoize(this::createHardware);

    /**
     * <p>
     * Getter for the field <code>currentPlatformEnum</code>.
     * </p>
     *
     * @return Returns the currentPlatformEnum.
     */
    public static PlatformEnum getCurrentPlatformEnum() {
        return currentPlatformEnum;
    }

    /**
     * Creates a new instance of the appropriate platform-specific
     * {@link oshi.software.os.OperatingSystem}.
     *
     * @return A new instance of {@link oshi.software.os.OperatingSystem}.
     */
    public OperatingSystem getOperatingSystem() {
        return os.get();
    }

    private OperatingSystem createOperatingSystem() {
        switch (currentPlatformEnum) {

        case WINDOWS:
            return new WindowsOperatingSystem();
        case LINUX:
            return new LinuxOperatingSystem();
        case MACOSX:
            return new MacOperatingSystem();
        case SOLARIS:
            return new SolarisOperatingSystem();
        case FREEBSD:
            return new FreeBsdOperatingSystem();
        default:
            throw new UnsupportedOperationException("Operating system not supported: " + Platform.getOSType());
        }
    }

    /**
     * Creates a new instance of the appropriate platform-specific
     * {@link oshi.hardware.HardwareAbstractionLayer}.
     *
     * @return A new instance of {@link oshi.hardware.HardwareAbstractionLayer}.
     */
    public HardwareAbstractionLayer getHardware() {
        return hardware.get();
    }

    private HardwareAbstractionLayer createHardware() {
        switch (currentPlatformEnum) {

        case WINDOWS:
            return new WindowsHardwareAbstractionLayer();
        case LINUX:
            return new LinuxHardwareAbstractionLayer();
        case MACOSX:
            return new MacHardwareAbstractionLayer();
        case SOLARIS:
            return new SolarisHardwareAbstractionLayer();
        case FREEBSD:
            return new FreeBsdHardwareAbstractionLayer();
        default:
            throw new UnsupportedOperationException("Operating system not supported: " + Platform.getOSType());
        }
    }
}


public class TesteOS {
	public static void main(String[] args) {
		OS os = new OS();
		
		System.out.println(os.getOS().getBitness());
		System.out.println(os.getOS().getFamily());
		System.out.println(os.getOS().getManufacturer());
		System.out.println(os.getOS().getVersionInfo());

		
	}
}

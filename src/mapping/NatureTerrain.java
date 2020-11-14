package mapping;
public enum NatureTerrain {
	EAU("eau.png"), FORET("foret.png"), ROCHE("roche.png"), TERAIN_LIBRE("terain_libre.png"),HABITAT("habitat.png");
	private String filePath;

	private NatureTerrain(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}
	
}

package mapping;

public enum NatureTerrain {
	EAU("img/eau.png"), FORET("img/foret.png"), ROCHE("/home/imadrafai/tpjava/img/roche.png"), TERRAIN_LIBRE("img/terrain_libre.png"),HABITAT("img/habitat.png");
	private String filePath;

	private NatureTerrain(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}
	
}

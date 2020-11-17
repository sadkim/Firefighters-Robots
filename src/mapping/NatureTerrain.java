package mapping;

public enum NatureTerrain {
	EAU("img/eau.png","img/burned_house.jpg"), FORET("img/foret.png","img/burned_house.jpg"), ROCHE("img/roche.png","img/burned_house.jpg"), TERRAIN_LIBRE("img/terrain_libre.png","img/burned_house.jpg"),HABITAT("img/habitat.png","img/burned_house.jpg");
	private String filePath;
    private String fileFire;

	private NatureTerrain(String filePath,String fileFire) {
		this.filePath = filePath;
        this.fileFire =fileFire;
	}

	public String getFilePath() {
		return filePath;
	}

    public String getFileFire(){
        return fileFire;
    }
	
}

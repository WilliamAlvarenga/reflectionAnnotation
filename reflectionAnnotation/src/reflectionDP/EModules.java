package reflectionDP;

public enum EModules {
	
	SINGER (new Singer().run()),
	REGISTER(new Register().run());

	private String _className;
	
	EModules(String className) {
		this._className = className;
		
	}

	public String getClassName() {
		return this._className;
	}
	
	
}

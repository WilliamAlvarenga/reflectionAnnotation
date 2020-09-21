package reflectionDP.implementation;

import reflectionDP.annotation.Module;
import reflectionDP.model.Register;
import reflectionDP.model.Singer;

public enum EModules {
	
	@Module("singerMod")
	SINGER (new Singer().run()),
	@Module("registerMod")
	REGISTER(new Register().run());

	private String _className;
	
	EModules(String className) {
		this._className = className;
		
	}

	public String getClassName() {
		return this._className;
	}
	
	
}

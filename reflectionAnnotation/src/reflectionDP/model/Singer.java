package reflectionDP.model;

import reflectionDP.annotation.Command;
import reflectionDP.interfaces.ICommand;

public class Singer implements ICommand {

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return this.getClass().getCanonicalName();
	}

	@Command("sing")
	public void sing() {
		System.out.print("Singing!!!");
	}
	
	@Command("talk")
	public void talk() {
		System.out.print("talking!!!");
	}
	
}

package reflectionDP.model;

import reflectionDP.annotation.Command;
import reflectionDP.interfaces.ICommand;

public class Register  implements ICommand{

	@Override
	public String run() {		
		return this.getClass().getCanonicalName();
	}

	@Command("printSomething")
	public void printSomething() {
		System.out.print("REGISTRO: Imprimindo algo!!!");
		
	}
	
	@Command("help")
	public void help() {
		System.out.print("REGISTRO: HELP!!!");
		
	}
}

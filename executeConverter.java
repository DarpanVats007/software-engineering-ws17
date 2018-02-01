
public class executeConverter {
	
	ICommand toConvertCommand;
	
	public executeConverter(ICommand newtoEuroCommand) {	
		toConvertCommand = newtoEuroCommand;	
	}
	
	public void runExecution () {		
		toConvertCommand.executeCommand();
	}
}

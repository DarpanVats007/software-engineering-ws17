import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

import java.util.HashMap;

class Main {
	
	public static UnitConverter Converter = null;
	public static LinkedList<String> scannedUserInputList = new LinkedList<String>();
	public static LinkedList<ICommand> commandList = new LinkedList<ICommand>();
	
	
	public static void main(String[] args) {

		unitCovnerterUserPrompt();
		Scanner userInputScanner = new Scanner(System.in);

		try {
			while (userInputScanner.hasNext()) {
				String input = userInputScanner.nextLine();
				collectScannedUserInput(input); //read scanned user inputs into a LinkedList<String>
			}
			
		/**
		 *  processScannedUserInput() function implements; 
		 *  ->   i. create Command *Object for every LinkedList<String> input
		 *  ->  ii. create a LinkedList<ICommand>  of all commands  
		 *  -> iii. after pressing CTRl-D, automatically execute all commands
		 */
			processScannedUserInput();			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		finally {	
			userInputScanner.close();
		}
	}
	
	public static void unitCovnerterUserPrompt() {
		
		String keyPrompt = 
		   '\n' + "Enter ConverterType & Value in format : "
			    + "KilometersToMiles 100" + '\n'
				+ "key: DollarToEuro" + '\n' 
				+ "key: EuroToDollar" + '\n'
				+ "key: KilometersToMiles" + '\n' 
				+ "key: MilesToKilometers" + '\n'
				+ "key: GramsToOunces" + '\n' 
				+ "key: OuncesToGrams" + '\n' + '\n' 
				
				+ "To invert Converter, Enter ConverterType & Value in format : "
				+ "invertDollarToEuro 100" + '\n' 			
				+ "key: invertDollarToEuro" + '\n' 
				+ "key: invertEuroToDollar" + '\n'
				+ "key: invertKilometersToMiles" + '\n' 
				+ "key: invertMilesToKilometers" + '\n'
				+ "key: invertGramsToOunces" + '\n' 
				+ "key: invertOuncesToGrams" + '\n' + '\n' 
				
				+ "To decorate Converter, Enter ConverterType & Value in format : "
				+ "toGrain 100" + '\n' 	
				+ "key: toGrain - (Grams to Grain)" + '\n' 
				+ "key: TroyOunce - (Ounce to Troy Ounce)" + '\n'
				+ "key: toYards - (Kilometers to Yards)" + '\n'
				+ "key: toNauticalMiles - (Miles to Nautical Miles)" + '\n'
				+ "key: newExchangeRate - (Euro to Euro*(new Exchange Rate))" + '\n' 
				+ "key: toAustralianDollar - (Dollar to Australian Dollar)" + '\n' + '\n' ;
		
		System.out.print(keyPrompt);
	}
	
	public static void collectScannedUserInput(String userInput) {
		
	
		
		scannedUserInputList.add(userInput);	
			}
	
	public static void processScannedUserInput() throws noValueEx, multiValueEx, negativeValueEx {
	
		System.out.println("");

		for (int i = 0; i < scannedUserInputList.size(); i++)  // create encapsulated ICommand Objects from LinkedList<String>)
			
		{
			
			try {
				
				String test = scannedUserInputList.get(0);
				System.out.println(""+test);
				
				
			}
			
			catch (IndexOutOfBoundsException e) {
			
			System.out.println(" Converter type and value not provided");	
			
			}   
			
				String[] part = scannedUserInputList.get(i).split("(?<=\\D)(?=\\d)");
				String key = part[0].trim();
				double numericValue = Double.parseDouble(part[1]);
				
			    String ConvArgs = scannedUserInputList.toString();
				 	
				String[] NumValueinStr = ConvArgs.replaceAll("[^0-9.]+", " ").trim().split(" "); 
				
				
				    if (key == null) 
					
				    	throw new noValueEx("Error: No Converter type given");
				
					if (NumValueinStr.length>0) 
						
						throw new multiValueEx("Error: Multiple converters given: please give single  given");
					
					if(key.equals("DollarToEuro") || key.equals("EuroToDollar") ||       
							key.equals("invertDollarToEuro") || key.equals("invertEuroToDollar") ||
							key.equals("newExchangeRate") || key.equals("toAustralianDollar")) {
		 				if (NumValueinStr[0].contains("-")) 
							throw new negativeValueEx("Error: Plese give a positive vale to convert");
		 				
					}   
		 				
		 				
				
					
		
		
			
			ICommand converterCommand =  createCommand(part);	
			converterCommand.setKey(key);
			converterCommand.setValue(numericValue);
			commandList.add (converterCommand); //create a List of commands to execute in LinkedList<ICommand>
		}
		for (int i = 0; i < commandList.size(); i++) { //automatically process all commands
			executeConverter newCommandExecution = new executeConverter(commandList.get(i));
			newCommandExecution.runExecution();		
		}
	}
	
	private static HashMap<String, ICommand> commandMap = new LinkedHashMap<>();	
	
	public static ICommand createCommand(String[] scannerUserInput) {
		
		String commandKey = scannerUserInput[0].trim();
		ICommand command = null;
		commandMap.put("DollarToEuro", new toEuroCommand(Converter));
		commandMap.put("EuroToDollar", new toDollarCommand(Converter));
		commandMap.put("OuncesToGrams", new toGramsCommand(Converter));
		commandMap.put("GramsToOunces", new toOuncesCommand(Converter));
		commandMap.put("KilometersToMiles", new toMilesCommand(Converter));
		commandMap.put("MilesToKilometers", new toKilometersCommand(Converter));
		
		commandMap.put("invertDollarToEuro", new invertToEuroCommand(Converter));
		commandMap.put("invertEuroToDollar", new invertToDollarCommand(Converter));
		commandMap.put("invertOuncesToGrams", new invertToGramsCommand(Converter));
		commandMap.put("invertGramsToOunces", new invertToOuncesCommand(Converter));
		commandMap.put("invertKilometersToMiles", new invertToMilesCommand(Converter));
		commandMap.put("invertMilesToKilometers", new invertToKilometersCommand(Converter));
				
		commandMap.put("toGrain", new toGrainCommand(Converter));		
		commandMap.put("toYards", new toYardsCommand(Converter));
		commandMap.put("TroyOunce", new toTroyOunceCommand(Converter));
		commandMap.put("toNauticalMiles", new toNauticalMilesCommand(Converter));
		commandMap.put("newExchangeRate", new toNewExchangeRateCommand(Converter));
		commandMap.put("toAustralianDollar", new toAustralianDollarCommand(Converter));

		if (commandMap.containsKey(commandKey)) {
			
		
			command = commandMap.get(commandKey);
		} else {
			command = null;
			System.out.println("Invalid key in List ! Please Re-Enter Commands");		
		}
		return command;
		
	}

};
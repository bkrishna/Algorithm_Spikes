package com.spike.Keycounts;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 1) Write a function that sums up keys in a text file. The file contains data in the format of
	"key,count" where key is a string and count is an BigDecimal. 
	Each line will only contain one key-count pair. 
	The output should contain each key occurring in the file along with the sum of 
	the count for all occurrences of a given key.
	For Example:
	John,2
	Jane,3
	John,4
	Jane,5
	Would result in the output: "The total for John is 6. The total for Jane is 8."
	
	ASSUMPTIONS MADE:
	
	1) The keys are case sensitive. Example Buggs and buggs is considered two different person.
	2) A line which consists of a String, Number is considered as valid input. Others are considered as invalid.
	3) If a line consists of a value John,,,4 is still considered valid input.
	4) Printed the invalid inputs as well in the output to view the lines that was discarded
	5) Choosing the input file dynamically is beyond the scope of the program.

	INSTRUCTIONS:
	
	1) Kindly modify the path to the keyCountsInputFile in the program according to where you have placed the file in your system.
	   You can also give your own input file, Just modify the path in the code.
	
 * @author bkrishna
 */
public class KeyCounts {
	
	public static void main(String[] args) {
		
		String filePath = "/Users/bkrishna/spikes/Algorithm_Spikes/src/com/spike/Keycounts/keyCountsInputFile"; 
		try {
			BufferedReader bufferedReaderInput = new BufferedReader(new FileReader(filePath));
			String inputLine = "";
			Map<String, BigDecimal> mapOfKeysAndCounts = new LinkedHashMap<String, BigDecimal>();
			List<String> invalidInputs = new ArrayList<String>();
			while (bufferedReaderInput.ready()) {
				try {
					inputLine = bufferedReaderInput.readLine();
					if (!inputLine.isEmpty()) {
						String[] inputLineArray = inputLine.split(",");
						List<String> validInput = removeWhiteSpaces(inputLineArray);
						if (validInput.size() == 2) {
							populateMapOfKeysAndCounts(mapOfKeysAndCounts, validInput);
						} else {
							invalidInputs.add(inputLine);
						}
					}
				} catch (NumberFormatException e) {
					invalidInputs.add(inputLine);
				}
			}
			bufferedReaderInput.close();
			printFinalOutput(mapOfKeysAndCounts, invalidInputs);
		} catch (FileNotFoundException e) {
			System.out.println("The file is not found on the specified location.");
		} catch (IOException e) {
			System.out.println("Error reading a line.");
		}
	}

	private static void printFinalOutput(Map<String, BigDecimal> mapOfKeysAndCounts, List<String> invalidInputs) {
		
		System.out.println("##Valid Keys and its Sum##");
		for (Map.Entry<String, BigDecimal> entry : mapOfKeysAndCounts.entrySet()) {
			System.out.println("The total for " + entry.getKey() + " is "+ entry.getValue());
		}
		System.out.println("##Invalid Inputs##");
		for (String invalidValue : invalidInputs) {
			System.out.println("Not a valid entry:" + invalidValue);
		}
	}

	private static void populateMapOfKeysAndCounts(Map<String, BigDecimal> mapOfKeysAndCounts,List<String> validatedInput) {
		
		if (mapOfKeysAndCounts.containsKey(validatedInput.get(0))) {
			mapOfKeysAndCounts.put(validatedInput.get(0), (mapOfKeysAndCounts.get(validatedInput.get(0))).add(new BigDecimal(validatedInput.get(1))));
		} else {
			mapOfKeysAndCounts.put(validatedInput.get(0), new BigDecimal(validatedInput.get(1)));
		}
	}
	
	private static List<String> removeWhiteSpaces(String[] inputLineArray) {

		List<String> validatedInput = new ArrayList<String>();
		for (int i = 0; i <= inputLineArray.length - 1; i++) {
			if (!inputLineArray[i].isEmpty()) {
				validatedInput.add(inputLineArray[i].replaceAll("\\s+", ""));
			}
		}
		return validatedInput;
	}
}

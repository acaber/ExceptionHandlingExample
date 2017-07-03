/*
 * Rebecca Johnson
 * 7/3/17
 * Demonstrates handling exceptions and exception propagation
 */
public class ExceptionPropagationExample {

	//field that holds the array of names
	private static String[] arrayOfNames = {"Henry", "George", "Chris", "Larry", "Ben", "Clair"};
	
	//declares an array of names
	private static String[] names = new String[3];
	
	//main method
	public static void main(String[] args) {
		
		//tells the user which method we are in
		System.out.println("main method: \n");
		
		//calls throwingException method and sends over names array
		setNames(names);
		
		//tells the user which method we are in
		System.out.println("main method: \n");
		
		//outputs results from the names array
		for(int i = 0; i < names.length; i++) 
			System.out.println("Name " + (i + 1) + ": " + names[i]);
	}
	
	//method that assigns the names from the arrayOfNames array to the names array
	private static String[] setNames(String[] array) {
		
		//tells the user which method we are in
		System.out.println("setNames method: \n");
		
		if(arrayOfNames.length != names.length)
			throwingException(array);
		else{
			//assigns the names to the array
			for(int i = 0; i < array.length; i++)
				array[i] = arrayOfNames[i];
		}
		
		return array;
	}
	
	//method that handles the exception
	private static String[] throwingException(String[] nameList) throws ArrayIndexOutOfBoundsException {
		
		//tells the user which method we are in
		System.out.println("throwingException method: \n");
		
		
			//try-catch block
			try {
				//tries to set values into the array
				for(int i = 0; i < arrayOfNames.length; i++){
					nameList[i] = arrayOfNames[i];
				}
			
			}
			catch(ArrayIndexOutOfBoundsException exception) {
			
				//assigns the names array a new length
				names = new String[arrayOfNames.length];
			
				//calls the setNames method but with new array size
				setNames(names);
			}
			
		
		//if try-catch does not throw exception, it will return original array
		return nameList;
		
	}
}



import java.util.ArrayList;
import java.util.List;

/******************************************************************************************
* LegoBatmanFan						11 June 2017
* 
* ManipulateStringRecursive.java
* It's common to use for loops to print strings, but what about using recursion? AND not
* using local variables? Hmmmm...
* 
* Use with ManipulateString.java
*-----------------------------------------------------------------------------
* Modification History
* Date				Author				Description
*-----------------------------------------------------------------------------
* 11 June 2017		LegoBatmanFan		Created
******************************************************************************************
*/

public class ManipulateStringRecursive {

	//Print the string recursively, with no local variables
	public void printStringRecursive(char myString[], int max, int index){
		if(index < max){
			System.out.print(myString[index] + " ");
			index++;
			printStringRecursive(myString, max, index);
		}
	}
	
	//Print the reverse of the string with no local variables
	public void printReverseStringRecursive(char myString[], int max){
		if(max >= 0){
			System.out.print(myString[max] + " ");
			max--;
			printReverseStringRecursive(myString, max);
		}
	}
}

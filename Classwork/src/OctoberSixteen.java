
public class OctoberSixteen {

	//EXAM ANSWER
	
	
	//printreverse(head);
	
	//prints a 9,10,15,17 list backward like such
	// 17,15,10,9
	//TEST THIS
	//void print reverse(Node aNode){
	/*
	 * if(aNode==null){ do nothing }
	 * else{
	 * printreverse(aNode.getNext());
	 * System.out.println(aNode.getItem());}
	 */
	
	
	
	
	/**SEARCHING
	 * 
	 * Objective: Find target value in the array
	 * pre-condition: THE ARRAY MUST BE SORTED LOWEST -> LARGEST VALUE
	 * int[]a = {5,6,7,99,100,500}
	 * 
	 * public boolean findTarget(int[] array, int targetVal){
	 * boolean foundTarget = false;
	 * for(int i =0; i< array.length;i++){
	 * 		if( array[i]==targetVal){
	 * 			return true; //THIS BREAKS THE METHOD
	 * 			}
	 * 		}
	 * 	return false; 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public boolean findTarget(Comparable[] elementArray, Comparable target){
	 * 
	 * for(int i =o;i<elementArray.length;i++){
	 * 
	 * if(elementArray[i].compareTo(target)==0){ //if they're equal
	 * 		return true;
	 * 			}
	 * 		}
	 * return false;
	 * }
	 * 
	 * 
	 * USING NODES - BINARY SEARCH (Iterative) //Find the middle
	 * {8,9,10,12,13,15,16} 
	 * public boolean binarySearch(int[] array, int targetValue){
	 * 	int minIndex = 0;
	 * 	int maxIndex = array.length;
	 * 
	 * 	while(maxIndex >= minIndex){
	 * 		// 1. Find the middle
	 * 		int middleIndex = (maxIndex + minIndex)/2;
	 * 		// 2. Find if the target is less than the middle
	 * 		if(target< array[midIndex]){
	 * 			maxIndex = middleIndex -1;
	 *			}
	 *		else if(target>array[midIndex]){
	 *			minIndex = middleIndex +1;
	 *			}
	 *		else{
	 *			return true;
	 *			}
	 * 		}
	 * 	return false; 
	 * }
	 * 
	 * 
	 * 
	 * public boolean binarySearch(int[] array, int targetVal, int minIndex, int maxIndex){
	 * if (maxIndex<minIndex){
	 * return false;}
	 * else{
	 * int middle = (maxIndex + minIndex)/2;
	 *	if(targetVal< array[middle]){
	 *		binarySearch(array, targetVal, minIndex, middle-1);
	 *		}
	 *	if(targetVal > array[middle]){
	 *		binarySearch(array, targetVal, middle+1, maxIndex);
	 *		}
	 *	else{
	 *		return true; 
	 *		}
	 *
	 *	 }
	 * return false;
	 * 
	 * }
	 */

}

//Kyle Phillips
//Problem 7
package midterm;
import java.util.Scanner;
public class RRScheduler {

    public static void main(String args[]) {
    	//initalize a scanner
            Scanner RRscan = new Scanner(System.in);
//initalize variables and arrays
     int waitTime[];
     int burstTime[];
     int runTime[];
     int n;
     int q;
     int total;

     waitTime = new int[10];
     burstTime = new int[10];
     runTime = new int[10];
//input the amount of proccessess
System.out.println("Enter the number of processes:");

	 n = RRscan.nextInt();
//input the burst time
System.out.println("Enter the burst time:");

//loops from i to the length of the number of proccesses above
	 for(int i = 0;i<n;i++) { 
		//Prints out the process number
		 	System.out.println("\nProcess["+(i+1)+"]: ");	
			//Records the bursttime
		 	burstTime[i] = RRscan.nextInt(); 
		 	//sets bursttime at i to our runtime at i
		 	runTime[i] = burstTime[i]; 
		 	//set the waittime to zero at index
			waitTime[i] = 0; 
} 
//input the quantum
System.out.println("Enter the Quantum: "); 

//initalize quantum variables 
	 q = RRscan.nextInt();
	 int p = n; 
	 int i = 0;
	 int time = 0; 
	 

	 
	 waitTime[0]=0; 
//Checks if the runtime at our index is greater then our quantum while our proccess amount isn't zero
	 while(p!=0) { 
		 
		 if(runTime[i] > q){
			 //if our runtime at i is greater then our quantum add our time and quantum to get our new time
			 time += q;
			 //subtract our quantum from our runtime variable at i
			 runTime[i] -= q;
			 //print out our process number and the time it requires to run
			 System.out.println(" Process["+(i+1)+"] = " + time);
			 
   }
		 	//checks if our runtime is less than or equal to our quantum and if it is also greater than zero
		 else if(runTime[i] <= q && runTime[i]>0){
	//adds our runtime and our time
			 time += runTime[i];
			 //calculates our new runtime
			 runTime[i] = runTime[i] - runTime[i];
			 //prints out our process number and the time it takes to run. 
			 System.out.println(" Process["+(i+1)+"] = " + time);
			 
			 p--;

}
//increment i and if i is equal to n set i = to zero.
		 i++;
		 if(i==n){

			 i=0;
}
}
}
}
//Kyle Phillips

import java.util.*;

public class FirstComeFirstServe {

	
	public static void main(String[] args)
	{
		//scanner for inputs
		Scanner scan = new Scanner(System.in);
		//variables used for our Arraylist data i for what job, bursttime for its processing time
		int i = 1;
		int bursttime = 0;
		
		ArrayList<Processes> processjobs = new ArrayList<Processes>();
		
		
		//input the desired processes
		System.out.println("Enter Desired # Of Processes:");
		//amount of jobs to be calculated throughout the scheduler
		int totaljobs = scan.nextInt();
		
		//inputs a burst time for each job to be processed
			for(int index = 1; index < totaljobs +1; index++)
		{
				
			System.out.println("Enter the burst time for process " + index + ":");
			bursttime = scan.nextInt();
			//adds our inputed jobs to our arraylist
			processjobs.add(new Processes(i, bursttime));
			
		}
	
	//total time the processes is using resources
		int totalturn = 0;
		//average time each process is using resources
		double averageturn = 0;
		//total time the process spent waiting 
		int totalwaittime = 0;
		//average time  each process spends waiting
		double averagewaittime = 0;
		
		//takes the tasks in the order they were put in
		for (int jobs = 1; jobs < totaljobs; jobs++) {
			
			Processes j = processjobs.remove(0);
				// calculates the total process time, wait time, and average wait
				totalturn += j.bursttime;
				totalwaittime = totalturn - j.bursttime;
				averagewaittime += totalwaittime;
				// prints out our burst time our processing time and our wait time for each job
				System.out.println("The burst time for job " + (jobs) + " is: " + j.bursttime );
				System.out.println("The total time processing including process " + (jobs) + " is: " + totalturn);
				System.out.println("The wait time for process " + (jobs) + " is: " + totalwaittime);
				//System.out.print(" - P" + j.i + " - " + totalturn);
			
		}
		// prints out the average wait time and process time 
		System.out.println("\n---------- Average Wait and Process Times ----------");
		System.out.println("Average processing time: " + totalturn + "/" + totaljobs + " = " + ((1.0*totalturn)/totaljobs));
		System.out.println("\nAverage waiting time: " + averagewaittime + "/" + totaljobs + " = " + ((1.0*averagewaittime)/totaljobs));


}
}
//process class for incoming process 
	class Processes{
		
		public int i;
		public int bursttime;
		
		
		public Processes(int i, int bursttime)
		{
			this.i = i;
			this.bursttime = bursttime;
		}
		}
		

//	Enter Desired # Of Processes:
//		5
//		Enter the burst time for process 1:
//		2
//		Enter the burst time for process 2:
//		3
//		Enter the burst time for process 3:
//		4
//		Enter the burst time for process 4:
//		5
//		Enter the burst time for process 5:
//		6
//		The burst time for job 1 is: 2
//		The total time processing including process 1 is: 2
//		The wait time for process 1 is: 0
//		The burst time for job 2 is: 3
//		The total time processing including process 2 is: 5
//		The wait time for process 2 is: 2
//		The burst time for job 3 is: 4
//		The total time processing including process 3 is: 9
//		The wait time for process 3 is: 5
//		The burst time for job 4 is: 5
//		The total time processing including process 4 is: 14
//		The wait time for process 4 is: 9

//		---------- Average Wait and Process Times ----------
//		Average processing time: 14/5 = 2.8

//		Average waiting time: 16.0/5 = 3.2
	



	


//Kyle Phillips

import java.util.*;

public class EarliestDeadline {

public static void main(String args[]) {
	
//create scanner
Scanner scan = new Scanner(System.in);

//input the desired processes
System.out.println("Enter Desired # Of Processes:");


//intialize the number of processes being worked with
int processes = scan.nextInt();

//create the arrays
int jobs[] = new int[processes + 1];
int bursttime[] = new int[processes + 1];
int arrivaltime[] = new int[processes + 1];
int deadline[] = new int[processes + 1];
int processing[] = new int[processes + 1];
int waiting[] = new int[processes + 1];

for(int k = 1; k <= processes; k++) {
	arrivaltime[k] = k;
}

for(int k = 1; k <= processes; k++) {
	jobs[k] = k;
}
//temp variable used for swapping positions in arrays
int temp;
//total time the processes is using resources
int totalturn = 0;
//average time each process is using resources
double averageturn = 0;
//total time the process spent waiting 
int totalwaittime = 0;
//average time  each process spends waiting
double averagewaittime = 0;

//intalize the arrival times, burst times, and deadlines
for (int i = 1; i <= processes; i++) {

System.out.println("Enter the arrival time, the burst time, and the deadline for process " + i +"(0 = no deadline:");
arrivaltime[i] = scan.nextInt();
bursttime[i] = scan.nextInt();
deadline[i] = scan.nextInt();

//if there is no deadline assign the deadline to 1000 to ensure the job isn't lost
if(deadline[i] == 0) {
	deadline[i] = 1000;
}
}

//Takes jobs and sorts in order based on deadline(takes into consideration arrival time)

	for(int j = 0; j < processes; j++) {
		//checks if the arrival times are sorted in order of FCFS
		
		if(arrivaltime[j+1] < arrivaltime[j])
		{
			temp = deadline[j+1];
			deadline[j+1] = deadline[j];
			deadline[j] = temp;
			
			temp = jobs[j+1];
			jobs[j+1] = jobs[j];
			jobs[j] = temp;
			
			temp = bursttime[j+1];
			bursttime[j+1] = bursttime[j];
			bursttime[j] = temp;
			
			temp = arrivaltime[j+1];
			arrivaltime[j+1] = arrivaltime[j]; 
			arrivaltime[j] = temp;
			
		}
		//if not checks to see if the next deadline is lower then the current job and swaps if so

	else if(arrivaltime[j+1] == arrivaltime[j])
		{
			if(deadline[j+1] < deadline[j])
			{
				//swaps deadlines in deadline array
				temp = deadline[j + 1];
				deadline[j + 1] = deadline[j];
				deadline[j] = temp;
				
				//swaps position for jobs in jobs array
				temp = jobs[j + 1];
				jobs[j + 1] = jobs[j];
				jobs[j] = temp;
				
				//swaps burst positions in burst array
				temp = bursttime[j + 1];
				bursttime[j + 1] = bursttime[j];
				bursttime[j] = temp;
				
				//swaps the positions for processes in arrival times array
				temp = arrivaltime[j+1];
				arrivaltime[j+1] = arrivaltime[j];
				arrivaltime[j] = temp;
			}
		}
		
	}


//Calculates the run times/wait times based on the position in line to be computed

processing[1] = bursttime[1];

//continue above comment
for(int i = 2; i <= processes; i++) {
	
	processing[i] = bursttime[i] + processing[i -1];	
	waiting[i] = processing[i] - bursttime[i];
}




//printout all the data 

System.out.println( "***********Process information***********" );


for (int i = 1; i <= processes; i++) {

	//takes the jobs with no deadline back
	if(deadline[i] == 1000) {
		deadline[i] = 0;
	}
//prints each job in earliest deadline order based on arrival time	
System.out.println("------ Job " + (i) + " ------");
System.out.println("The arrival time for job " + (i) + " is: " + arrivaltime[i]);
System.out.println("The burst time for job " + (i) + " is: " + bursttime[i] );
System.out.println("The deadline provided for job " + (i) + " is: " + deadline[i]);
System.out.println("The total time processessing to complete job " + (i) + " is: " + processing[i]);
System.out.println("The total wait time to process for job " + (i) + " is: " + waiting[i]);

}


//calculates the total time spent processing,, average time spent processing, average wait time, and total wait time
for(int i = 1; i <= processes; i++) {
	
	totalturn += (waiting[i] + bursttime[i]) - arrivaltime[i];
	averageturn = totalturn / processes;
	totalwaittime += waiting[i] - arrivaltime[i];
	averagewaittime = totalwaittime / processes;
}

//prints overall totals and averages
System.out.println("-------- Final Numbers --------");
System.out.println("The total processing time: " + totalturn);
System.out.println("The average processing time: " + averageturn);
System.out.println("The total processing wait time: " + totalwaittime);
System.out.println("The average processing wait time: " + averagewaittime);
}
}




//OUTPUT WHEN ALL ARRIVAL TIMES ARE THE SAME(WORKS FINE)

//Enter Desired # Of Processes:
//5
//Enter the arrival time, the burst time, and the deadline for process 1(0 = no deadline:
//4
//3
//5
//Enter the arrival time, the burst time, and the deadline for process 2(0 = no deadline:
//4
//8
//9
//Enter the arrival time, the burst time, and the deadline for process 3(0 = no deadline:
//4
//6
//3
//Enter the arrival time, the burst time, and the deadline for process 4(0 = no deadline:
//4
//7
//4
//Enter the arrival time, the burst time, and the deadline for process 5(0 = no deadline:
//4
//1
//7
//***********Process information***********
//------ Job 1 ------
//The arrival time for job 1 is: 4
//The burst time for job 1 is: 6
//The deadline provided for job 1 is: 3
//The total time processessing to complete job 1 is: 6
//The total wait time to process for job 1 is: 0
//------ Job 2 ------
//The arrival time for job 2 is: 4
//The burst time for job 2 is: 7
//The deadline provided for job 2 is: 4
//The total time processessing to complete job 2 is: 13
//The total wait time to process for job 2 is: 6
//------ Job 3 ------
//The arrival time for job 3 is: 4
//The burst time for job 3 is: 3
//The deadline provided for job 3 is: 5
//The total time processessing to complete job 3 is: 16
//The total wait time to process for job 3 is: 13
//------ Job 4 ------
//The arrival time for job 4 is: 4
//The burst time for job 4 is: 1
//The deadline provided for job 4 is: 7
//The total time processessing to complete job 4 is: 17
//The total wait time to process for job 4 is: 16
//------ Job 5 ------
//The arrival time for job 5 is: 4
//The burst time for job 5 is: 8
//The deadline provided for job 5 is: 9
//The total time processessing to complete job 5 is: 25
//The total wait time to process for job 5 is: 17
//-------- Final Numbers --------
//The total processing time: 57
//The average processing time: 11.0
//The total processing wait time: 32
//The average processing wait time: 6.0


//Enter Desired # Of Processes:
//7
//Enter the arrival time, the burst time, and the deadline for process 1(0 = no deadline:
//8
//3
//7
//Enter the arrival time, the burst time, and the deadline for process 2(0 = no deadline:
//12
//2
//7
//Enter the arrival time, the burst time, and the deadline for process 3(0 = no deadline:
//6
//3
//7
//Enter the arrival time, the burst time, and the deadline for process 4(0 = no deadline:
//6
//7
//2
//Enter the arrival time, the burst time, and the deadline for process 5(0 = no deadline:
//3
//6
//1
//Enter the arrival time, the burst time, and the deadline for process 6(0 = no deadline:
//3
//9
//5
//Enter the arrival time, the burst time, and the deadline for process 7(0 = no deadline:
//7
//4
//11
//***********Process information***********
//------ Job 1 ------
//The arrival time for job 1 is: 3
//The burst time for job 1 is: 6
//The deadline provided for job 1 is: 1
//The total time processessing to complete job 1 is: 6
//The total wait time to process for job 1 is: 0
//------ Job 2 ------
//The arrival time for job 2 is: 3
//The burst time for job 2 is: 9
//The deadline provided for job 2 is: 5
//The total time processessing to complete job 2 is: 15
//The total wait time to process for job 2 is: 6
//------ Job 3 ------
//The arrival time for job 3 is: 6
//The burst time for job 3 is: 7
//The deadline provided for job 3 is: 2
//The total time processessing to complete job 3 is: 22
//The total wait time to process for job 3 is: 15
//------ Job 4 ------
//The arrival time for job 4 is: 6
//The burst time for job 4 is: 3
//The deadline provided for job 4 is: 7
//The total time processessing to complete job 4 is: 25
//The total wait time to process for job 4 is: 22
//------ Job 5 ------
//The arrival time for job 5 is: 7
//The burst time for job 5 is: 4
//The deadline provided for job 5 is: 11
//The total time processessing to complete job 5 is: 29
//The total wait time to process for job 5 is: 25
//------ Job 6 ------
//The arrival time for job 6 is: 8
//The burst time for job 6 is: 3
//The deadline provided for job 6 is: 7
//The total time processessing to complete job 6 is: 32
//The total wait time to process for job 6 is: 29
//------ Job 7 ------
//The arrival time for job 7 is: 12
//The burst time for job 7 is: 2
//The deadline provided for job 7 is: 7
//The total time processessing to complete job 7 is: 34
//The total wait time to process for job 7 is: 32
//-------- Final Numbers --------
//The total processing time: 118
//The average processing time: 16.0
//The total processing wait time: 84
//The average processing wait time: 12.0
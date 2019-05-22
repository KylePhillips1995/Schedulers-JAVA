import java.util.Scanner;
import java.util.*;
public class EarliestDeadlineFirst {

	
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);

	//input the desired processes
	System.out.println("Enter Desired # Of Processes:");


	//intialize the number of processes being worked with
	int processes = scan.nextInt();
	
	
	int bursttime[] = new int[processes + 1];
	int deadline[] = new int[processes + 1];
	int processing[] = new int[processes + 1];
	int waiting[] = new int[processes + 1];
	int temp;
	int totalturn = 0;
	int averageturn = 0;
	int totalwaittime = 0;
	int averagewaittime = 0;

//intalize the arrival times, burst times, and deadlines
for (int i = 1; i <= processes; i++) {

System.out.println("Enter the burst time and the deadline for process " + i +"(0 = no deadline:");

bursttime[i] = scan.nextInt();
deadline[i] = scan.nextInt();

//if there is no deadline assign the deadline to 1000 to ensure the job isn't lost
if(deadline[i] == 0) {
	deadline[i] = 1000;
}
}
for(int i = 0; i < processes; i++) {
	for(int j = 0; j < processes; j++) {

	if(deadline[j+1] < deadline[j])
		{
	//swaps deadlines in deadline array
	temp = deadline[j + 1];
	deadline[j + 1] = deadline[j];
	deadline[j] = temp;
	
	//swaps burst positions in burst array
	temp = bursttime[j + 1];
	bursttime[j + 1] = bursttime[j];
	bursttime[j] = temp;
	
}
}
}

processing[1] = bursttime[1];

//continue above comment
for(int i = 2; i <= processes; i++) {
	
	processing[i] = bursttime[i] + processing[i -1];	
	waiting[i] = processing[i] - bursttime[i];
}

System.out.println( "***********Process information***********" );


for (int i = 1; i <= processes; i++) {

	//takes the jobs with no deadline back
	if(deadline[i] == 1000) {
		deadline[i] = 0;
	}
//prints each job in earliest deadline order based on arrival time	
System.out.println("------ Job " + (i) + " ------");
System.out.println("The burst time for job " + (i) + " is: " + bursttime[i] );
System.out.println("The deadline provided for job " + (i) + " is: " + deadline[i]);
System.out.println("The total time processessing to complete job " + (i) + " is: " + processing[i]);
System.out.println("The total wait time to process for job " + (i) + " is: " + waiting[i]);

}


//calculates the total time spent processing,, average time spent processing, average wait time, and total wait time
for(int i = 1; i <= processes; i++) {
	
	totalturn = totalturn + (waiting[i] + bursttime[i]);
	averageturn = totalturn / processes;
	totalwaittime = totalwaittime + waiting[i];
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



//Enter Desired # Of Processes:
//5
//Enter the burst time and the deadline for process 1(0 = no deadline:
//25
//10
//Enter the burst time and the deadline for process 2(0 = no deadline:
//2
//6
//Enter the burst time and the deadline for process 3(0 = no deadline:
//3
//1
//Enter the burst time and the deadline for process 4(0 = no deadline:
//12
//12
//Enter the burst time and the deadline for process 5(0 = no deadline:
//61
//2
//***********Process information***********
//------ Job 1 ------
//The burst time for job 1 is: 3
//The deadline provided for job 1 is: 1
//The total time processessing to complete job 1 is: 3
//The total wait time to process for job 1 is: 0
//------ Job 2 ------
//The burst time for job 2 is: 61
//The deadline provided for job 2 is: 2
//The total time processessing to complete job 2 is: 64
//The total wait time to process for job 2 is: 3
//------ Job 3 ------
//The burst time for job 3 is: 2
//The deadline provided for job 3 is: 6
//The total time processessing to complete job 3 is: 66
//The total wait time to process for job 3 is: 64
//------ Job 4 ------
//The burst time for job 4 is: 25
//The deadline provided for job 4 is: 10
//The total time processessing to complete job 4 is: 91
//The total wait time to process for job 4 is: 66
//------ Job 5 ------
//The burst time for job 5 is: 12
//The deadline provided for job 5 is: 12
//The total time processessing to complete job 5 is: 103
//The total wait time to process for job 5 is: 91
//-------- Final Numbers --------
//The total processing time: 327
//The average processing time: 65
//The total processing wait time: 224
//The average processing wait time: 44
Problem Statement: Consider the scheduling problem. n tasks to be scheduled on single processor. Let d1, ...,dn be deadline and p1,….pn be the profit of each task to execute on single processor is known. The tasks can be executed in any order but one task at a time and each task take 1 unit of time to execute. Design a greedy algorithm for this problem and find a schedule or sequence of jobs that gives maximum profit.
Program:
import java.util.*;
class Job {
    int jobID;
    int deadline;
    int profit;
    Job(int jobID, int deadline, int profit) {
        this.jobID = jobID;
        this.deadline = deadline;
        this.profit = profit;
    }
    int getprofit()
    {
        return profit;
    }
}
public class Ass_2{
   void final_ans(Job[] jobs, int n)
   {
       int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline) {
                maxDeadline = jobs[i].deadline;
            }
        }
        int m=maxDeadline;
        int[] slot=new int[m];
        Arrays.fill(slot, 0);
    Arrays.sort(jobs,Comparator.comparingInt(Job::getprofit).reversed());
    int cnt=0,total=0;
    for(int i=0;i<n && cnt<m;i++)
    {
        for(int j=jobs[i].deadline-1;j>=0;j--)
        {
            if(slot[j]==0)
            {
                slot[j]=jobs[i].jobID;
                cnt++;
                total+=jobs[i].profit;
                break;
            }
        }
 }
    System.out.println("Maximum profit is :"+total+" With following job slots");
    for(int i=0;i<m;i++)
    {
        System.out.println(slot[i]+" ");
    }
   } 
public static void main(String[] args)
{
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of Array");
    int n = sc.nextInt();

    Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter job ID, deadline, and profit for job " + (i + 1) + ":");
            int jobID = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(jobID, deadline, profit);
        }
    Ass_2 obj=new Ass_2();
    obj.final_ans(jobs,n);

}
}
Output:
Enter the size of Array
5
Enter job ID, deadline, and profit for job 1:
1
2
30
Enter job ID, deadline, and profit for job 2:
2
1
20
Enter job ID, deadline, and profit for job 3:
3
1
70
Enter job ID, deadline, and profit for job 4:
4
3
10
Enter job ID, deadline, and profit for job 5:
5
2
90
Maximum profit is :170 With following job slots
3 
5 
4 

=== Code Execution Successful ===

import java.util.*;
public class leakybucket{
static int min(int x,int y)
{
if(x<y)
return x;
else
return y;
}
public static void main(String args[])
{
int drop=0,mini,nsec,bsize,count=0,i,orate;
int inp[]=new int[25];
Scanner in=new Scanner(System.in);
System.out.println("enter bucket size");
bsize=in.nextInt();
System.out.println("enter operation rate");
orate=in.nextInt();
System.out.println("enter number of seconds");
nsec=in.nextInt();
for(i=0;i<nsec;i++)
{
System.out.println("enter the size of packet entering at "+(i+1)+" sec ");
inp[i]=in.nextInt();
}
System.out.println("SECOND \tPACKET RECIEVED\t PACKET SENT \tPACKET LEFT  \tPACKET DROPPED\n ");
for(i=0;i<nsec;i++)
{
count+=inp[i];
if(count>bsize)
{
drop=count-bsize;
count=bsize;
}
System.out.print(i+1);
System.out.print("\t\t"+inp[i]);
mini=min(count,orate);
System.out.print("\t\t"+mini);
count=count-mini;
System.out.print("\t\t"+count);
System.out.print("\t\t"+drop);
drop=0;
System.out.println();
}


for(;count!=0;i++)
{
if(count>bsize)
{
drop=count-bsize;
count=bsize;
}
System.out.print(i+1);
System.out.print("\t\t0");
mini=min(count,orate);
System.out.print("\t\t"+mini);
count=count-mini;
System.out.print("\t\t"+count);
System.out.print("\t\t"+drop);
drop=0;
System.out.println();
}
}
}


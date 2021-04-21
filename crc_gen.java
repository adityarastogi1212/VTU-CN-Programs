import java.io.*;
class crc_gen{
public static void main(String args[]) throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int [] data;
int [] div;
int [] divisor;
int []rem;
int [] crc;
int databits,divisorbits,totlen;
System.out.println("enter the no of bits:");
databits=Integer.parseInt(br.readLine());
data=new int[databits];
System.out.println("enter data bits:");
for(int i=0;i<databits;i++)
data[i]=Integer.parseInt(br.readLine());
System.out.println("enter no of bits in divsor");
divisorbits=Integer.parseInt(br.readLine());
divisor=new int[divisorbits];
System.out.println("enter the divisor bits");
for(int i=0;i<divisorbits;i++)
divisor[i]=Integer.parseInt(br.readLine());
totlen=databits + divisorbits-1;
div=new int[totlen];
rem=new int[totlen];
crc=new int[totlen];
for(int i=0;i<data.length;i++)
div[i]=data[i];
System.out.print("dividened after appending 0's) are :");
for(int i=0;i<div.length;i++)
System.out.print(div[i]);
System.out.println();
for(int j=0;j<div.length;j++)
{
rem[j]=div[j];
}
rem=divide(div,divisor,rem);
for(int i=0;i<div.length;i++)
{
crc[i]=(div[i]^rem[i]);
}
System.out.println();
System.out.println("crc code");
for(int i=0;i<crc.length;i++)
System.out.print(crc[i]);
System.out.println();
System.out.println("enter crc code of "+totlen+"bits :");
for(int i=0;i<crc.length;i++)
 crc[i]=Integer.parseInt(br.readLine());
 System.out.print("crc bits are");
 for(int i=0;i<crc.length;i++)
 System.out.print(crc[i]);
 System.out.println();
 for(int j=0;j<crc.length;j++)
 {
 rem[j]=crc[j];
 }
 rem=divide(crc,divisor,rem);
 for(int i=0;i<rem.length;i++)
 {
 if(rem[i]!=0)
 {
 System.out.println("error");
 break;
 }
 if(i==rem.length-1)
 System.out.println("no error");
 }
 System.out.println("thank you...:)");
 }
 static int[] divide (int div[],int divisor[],int rem[])
 {
 int cur=0;
 while(true)
 {
 for(int i=0;i<divisor.length; i++)
 rem[cur+i] =(rem[cur+i] ^ divisor[i]);
 while(rem[cur]==0 && cur!=rem.length-1)
 cur++;
 if((rem.length-cur)<divisor.length)
 break;
 }
 return rem;
 }
 }










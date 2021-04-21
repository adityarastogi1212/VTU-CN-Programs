import java.io.*;
import java.util.Scanner;
 public class rsa
{  
   private static int gcd(long m, long n)
{ 
  int r;       
  while ( n != 0 )
{     
  r = (int) (m%n);   
   m = n;       
n = r;        
 }         
return (int)m;  
   }     
public static void main(String[] args) 
{ 
 Scanner in = new Scanner(System.in); 
System.out.print("Enter message : ");  
 String message = in.nextLine();     
int size = message.length();      
 char[] msg = new char[size];     
 int[] enc = new int[size];    
 int[] dec = new int[size];      
 int p,q,n,e,d,phi,i,j,k;     
for (i = 0 ; i < size ; i++)    
  msg[i] = message.charAt(i);  
 System.out.print("Message(ASCII) to be Encrypted is : ");    
for (i = 0 ; i < size ; i++)       
System.out.print((int)msg[i]);     
 System.out.print("\nEnter two Prime numbers : ");    
 p = in.nextInt();  
  q = in.nextInt();     
 n = p * q;       
phi = (p - 1) * (q - 1);      
for (i = 2 ; i < phi ; i++)      
if ( gcd(i,phi) == 1 )    
 break;       
  e = i;     
for (k = 2 ; k < phi ; k++)    
  if ( ((e * k - 1) % phi) == 0 )    
   break;      
   d = k;       
 System.out.println("Value of e = "+ e +" & d = "+d); 
int[] num = new int[size];  
 for (int x = 0 ; x < size ; x++) 
{   
  num[x] = msg[x];     
  } 
 
for (i = 0 ; i < size ; i++)
{     
 enc[i] = 1;      
for (j = 0 ; j < e ; j++)       
enc[i] = (enc[i] * num[i]) % n;   
 }        
 for (i = 0 ; i < size ; i++)
{ 
dec[i] = 1;      
 for (j = 0 ; j < d ; j++)        
 dec[i] = (dec[i] * enc[i]) % n;   
}         
System.out.print("\nMessage(ASCII) to be Decrypting is : ");   
 for (i = 0 ; i < size ; i++)        
 System.out.print(dec[i]);       
  System.out.print("\nEncrypted message : ");   
for (i = 0 ; i < size ; i++)        
System.out.print(enc[i]);      
System.out.print("\nDecrypted message : ");   
for (i = 0 ; i < size ; i++)  
System.out.print((char)dec[i]);   
  } 
} 


Enter the text: hello
Enter the value of P and Q : 5,7
Encrypted Text is: 8 h 10 j 17 q 17 q 15 o
 Decrypted Text is: hello


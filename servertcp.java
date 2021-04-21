import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class servertcp
{
 public static void main(String args[]) throws IOException
 {
  ServerSocket ss= null;
  Socket s=null;
  try
  {
   ss= new ServerSocket(3000);
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  while(true)
  {
   try
   {
     System.out.println("server ready");
     s=ss.accept();
     System.out.println("client connected");
     InputStream istream=s.getInputStream();
     Scanner fread = new Scanner(new InputStreamReader(istream));
     String fileName=fread.nextLine();
     System.out.println("reading contents of"+fileName);
     Scanner contentRead = new Scanner(new FileReader(fileName));
     OutputStream ostream=s.getOutputStream();
     PrintWriter pwrite = new PrintWriter(ostream,true);
     String str;
     while(contentRead.hasNext())
     pwrite.println(contentRead.nextLine());
     pwrite.close();
     s.close();
   }
   catch(FileNotFoundException e1)
   {
     System.out.println("file not found");
     OutputStream ostream=s.getOutputStream();
     PrintWriter pwrite= new PrintWriter(ostream,true);
     pwrite.println("file not found");
     pwrite.close();
   }
   catch(Exception e)
   {
   }
  }
 }
}

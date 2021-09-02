import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

public static void main(String[] args) throws Exception
{
		File source = new File(args[0]);
		File dest =  new File(args[1]);
		long starttime  = System.currentTimeMillis();
		    InputStream is = null;
		    OutputStream os = null;
		    try {
		        is = new FileInputStream(source);
		        os = new FileOutputStream(dest);
		        int ch;
		        while ((ch = is.read()) != -1) {
		            os.write(ch);
		        }
		    } finally {
		        is.close();
		        os.close();
		    }
		    long endtime  = System.currentTimeMillis();
		    System.out.println("Time taken to copy " + source.length() /1024 + "kbs  is " +  (endtime - starttime)  + " ms");
}
}

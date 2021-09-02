import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class NIOCopy {

	public static void main(String[] args) throws Exception
{
		File source = new File(args[0]);
		File dest =  new File(args[1]);
		long starttime  = System.currentTimeMillis();
		FileInputStream is = null;
		FileOutputStream os = null;
		FileChannel inputchannel = null;
		 FileChannel outputChannel = null;
		    try {
		        is = new FileInputStream(source);
		        os = new FileOutputStream(dest);
		        inputchannel = is.getChannel();
		        outputChannel = os.getChannel();
		        ByteBuffer buf = ByteBuffer.allocate(1024*16);
		        int bytesRead = inputchannel.read(buf);
		        while (bytesRead != -1) {
		            buf.flip();
		            outputChannel.write(buf);
		            buf.clear();
		            bytesRead = inputchannel.read(buf);
		          }
		        
		    } finally {
		    	inputchannel.close();
		    	outputChannel.close();
		        is.close();
		        os.close();
		    }
		    long endtime  = System.currentTimeMillis();
		    System.out.println("Time taken to copy " + source.length() /1024 + "kbs  is " +  (endtime - starttime)  + " ms");
}
}

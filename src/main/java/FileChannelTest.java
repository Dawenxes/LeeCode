import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		FileChannel channel = new RandomAccessFile("test.txt", "rw").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1000);
		channel.write(buffer);
	}
}

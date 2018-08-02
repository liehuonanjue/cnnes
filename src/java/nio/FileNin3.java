package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileNin3 {
    public static void main(String[] args) {
        FileChannel channel = null;
        try {
//            找打指定的文件并且设置读写模式
            RandomAccessFile file = new RandomAccessFile("d:/a.txt", "rw");
//创建管道
            channel = file.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1204);
            byte[] bytes = new byte[1024];
            long length = file.length();
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < length; i += 1024) {
                if (length - i > 1024) {
                    buffer.get(bytes);
                } else {
                    buffer.get(new byte[(int) (length - i)]);
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("使用内存映射时间" + (endTime - beginTime));
            System.out.println("-------------------------------------------------------");
            beginTime = System.currentTimeMillis();
            while (channel.read(byteBuffer1) > 0) {
                byteBuffer1.flip();
                byteBuffer1.clear();
            }
            endTime = System.currentTimeMillis();
            System.out.println("使用普通io时间" + (endTime - beginTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {
    public static void main(String[] args) {
        System.out.println("d");
        //创建数组
        String[] bytee = {"dd", "dd", "dd"};
        //创建文件对象 自动创建
        File file = new File("d:/a.txt");
//        创建输出流对象
        FileOutputStream fos = null;
//        创建管道对应的实现类
        FileChannel fileChannel = null;

        try {
            fos = new FileOutputStream(file);
//          获取管道
            fileChannel = fos.getChannel();
//            创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            循环出数组的数据
            for (String s : bytee) {
//               将训话你的数据写缓冲区
                System.out.println(s.getBytes() );
                buffer.put(s.getBytes());
            }
//           从写模式切换读模式
            buffer.flip();
//            正在的写入
            fileChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileChannel.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}


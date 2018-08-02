package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FIleNio2 {
    //从文件a到文件b传数据
    public static void main(String[] args) {
//创建需要的两个文件
        File afile = new File("d:/a.txt");
        File bfile = new File("d:/b.txt");
//        创建输出流对象
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
//        创建管道对应的实现类
        FileChannel inputchannel = null;
        FileChannel outputchannel = null;
        try {
            fileInputStream = new FileInputStream(afile);
            fileOutputStream = new FileOutputStream(bfile);
//          获取管道
            inputchannel = fileInputStream.getChannel();
            outputchannel = fileOutputStream.getChannel();
//            创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
//           从写模式切换读模式
            int num = 0;
            while ((num = inputchannel.read(buffer)) != -1) {
//               切换模式
                buffer.flip();
                //写入到b文件里面
                outputchannel.write(buffer);
                //清空缓存区
                buffer.clear();
                System.out.println(buffer);
                System.out.println(num);
            }

//            正在的写入
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputchannel.close();
                outputchannel.close();
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

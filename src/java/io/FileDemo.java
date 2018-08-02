package io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class FileDemo
{

 static   Scanner input=new Scanner(System.in);

    public static void main( String[] args )
    {
        System.out.println( "*************欢迎进入文件操作系统*************" );
        System.out.println( "*************1.创建文件*************" );
        System.out.println( "*************2.删除文件*************" );
        System.out.println( "*************3.修改文件*************" );
        System.out.println( "*************4.创建文件夹*************" );
        System.out.println( "*************5.查询文件夹下所有的文件列表*************" );
        System.out.println( "*************请选择：*************" );

        //获取用户的输入
        int choose = input.nextInt();
        switch (choose){
            case 1://创建文件
                 createNewFile();
                break;
            case 2://删除文件
                 deleteFile();
                break;
            case 3://修改文件
                 updateFile();
                break;
            case 4://创建文件夹
                 mkdirs();
                break;
            case 5://查询文件夹下所有的文件列表
                 findFileList();
                break;
        }
    }
   // 查询文件夹下所有的文件列表
    private static void findFileList() {
        System.out.println("请您输入查询的文件夹名称：（默认是E：/）");
        String fileName = input.next();
        //创建File对象
        File file=new File("E:/"+fileName);
        File[] files = file.listFiles();
        int dirNums=0;
        int fileNums=0;
        //遍历集合
        for (File f:files){
            if (f.isDirectory()){
                dirNums++;
            }
            if (f.isFile()){
               fileNums++;
                System.out.println(f.getName());
            }
        }
        System.out.println("有多少个文件夹?"+dirNums);
        System.out.println("有多少个文件?"+fileNums);
    }

    //创建文件夹
    private static void mkdirs() {
        System.out.println("请您输入创建的文件夹名称：（默认是E：/）");
        String fileName = input.next();
        //创建File对象
        File file=new File("E:/"+fileName);
        if (file.mkdirs()){
            System.out.println("创建成功");
        }else{
            System.out.println("创建失败");
        }
    }

    //修改文件
    private static void updateFile() {
        System.out.println("请您输入需要修改文件的名称：（默认是E：/）");
        String oldFileName = input.next();
        System.out.println("请您输入文件的新名称：（默认是E：/）");
        String newFileName = input.next();
        //创建File对象
        File oldFile=new File("E:/"+oldFileName);
        File newFile=new File("E:/"+newFileName);
        if(oldFile.renameTo(newFile)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

    }

    //删除文件
    private static void deleteFile() {
        System.out.println("请您输入删除文件的名称：（默认是E：/）");
        String fileName = input.next();
        //创建File对象
        File file=new File("E:/"+fileName);
        if (file.exists()){  //文件存在才能删除
            boolean flag = file.delete();
            if (flag){
                System.out.println("文件删除成功！");
            }else{
                System.out.println("文件删除失败！");
            }
        }else{
            System.out.println("该文件不存在！");
        }
    }

    //创建文件
    private static void createNewFile() {
        System.out.println("请您输入文件的名称：（默认是E：/）");
        String fileName = input.next();
        //创建File对象
        File file=new File("E:/"+fileName);
        if (file.exists()){  //文件已经存在
            System.out.println("该文件已经存在！");
        }else{
            try {
             boolean  flag= file.createNewFile();
             if (flag){
                 System.out.println("文件创建成功！");
             }else{
                 System.out.println("文件创建失败！");
             }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

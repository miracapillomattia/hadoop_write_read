package com.example.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HdfsFileReader {

    public static void main(String[] args) throws IOException {
//        ReadWriteHDFSExample.checkExists();
//        ReadWriteHDFSExample.createDirectory();
//        ReadWriteHDFSExample.checkExists();
//        ReadWriteHDFSExample.writeFileToHDFS();
//        ReadWriteHDFSExample.appendToHDFSFile();
    	HdfsFileReader.readFileFromHDFS();
    }

    public static void readFileFromHDFS() throws IOException {
        Configuration configuration = new Configuration();
      
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        
        Path hdfsReadPath = new Path("C:\\ITS\\text1.txt");
        
        FSDataOutputStream outputStream = fileSystem.create(hdfsReadPath);
        outputStream.writeBytes("Ho creato un file di testo e ho creato un Write&Read");
        outputStream.close();
        
        //Init input stream
        FSDataInputStream inputStream = fileSystem.open(hdfsReadPath);
        
        //Classical input stream usage
        String out = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(out);

    
        inputStream.close();
        fileSystem.close();
    }

//    Configuration configuration = new Configuration();
//
//    FileSystem fileSystem = FileSystem.get(configuration);
//
//    String directoryName = "C:/ITS/text.txt";
//    Path path = new Path(directoryName);
//    
//
//    FSDataOutputStream fsDataOutputStream = fileSystem.create(path, true);
//    fsDataOutputStream.writeBytes("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
//    fsDataOutputStream.close();
    
    
    
    
    
    /*BufferedReader bufferedReader = new BufferedReader(
    new InputStreamReader(inputStream, StandardCharsets.UTF_8));

String line = null;
while ((line=bufferedReader.readLine())!=null){
System.out.println(line);
}*/

}


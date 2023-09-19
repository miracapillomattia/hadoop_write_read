package com.example.hdfs;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.BufferedWriter;
import java.io.IOException;



public class HdfsFileWriter {

    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();

        FileSystem fileSystem = FileSystem.get(configuration);

        String directoryName = "C:/ITS/text.txt";
        Path path = new Path(directoryName);
        

        FSDataOutputStream fsDataOutputStream = fileSystem.create(path, true);
        fsDataOutputStream.writeBytes("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        fsDataOutputStream.close();
    }

}
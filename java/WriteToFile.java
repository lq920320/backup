package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liuqian
 * @date 2019/10/26 17:03
 */
public class WriteToFile {
    public void WriteToFile() throws IOException {
        StringBuffer content = new StringBuffer();
        writeToFile(content, "data1.txt");
    }

    private void writeToFile(StringBuffer content, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, false);
        FileChannel channel = fos.getChannel();
        ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
        buf.put(content.toString().getBytes());
        buf.flip();
        channel.write(buf);
        channel.close();
        fos.close();
    }
}

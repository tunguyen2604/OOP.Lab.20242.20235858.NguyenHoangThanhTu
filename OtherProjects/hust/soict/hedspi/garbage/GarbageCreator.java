package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    String filename = "\"D:\\Học liệu\\OOP\\OOP.Lab.20242.20235858.NguyenHoangThanhTu\\OtherProjects\\result.txt\""; // test.exe is the name or path to an executable file
    byte[] inputBytes = {0};
    long startTime, endTime; {

    try {
        inputBytes = Files.readAllBytes (Paths.get(filename));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    startTime = System.currentTimeMillis();
    StringBuilder outputStringBuilder = new StringBuilder();
    for(byte b : inputBytes) {
        outputStringBuilder.append((char)b);
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    }
}
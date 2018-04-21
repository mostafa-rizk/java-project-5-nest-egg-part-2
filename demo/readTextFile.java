import java.io.*;
import java.util.*;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class readTextFile {
  public static void main(String args[]) throws IOException {
    double data;
    FileReader fr = new FileReader("data.txt");
    BufferedReader textReader = new BufferedReader(fr);
			
    for (int i = 1; i <= 5; i++){
      data = Double.parseDouble(textReader.readLine());
      System.out.println(data);
    }
  }
}

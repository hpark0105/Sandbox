package Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
5
add hack
add hacks
add apple
find h
find a
should return [2,0]
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> queries = new ArrayList<>();

    for (int i = 0; i < queriesRows; i++) {
      queries.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
    }

    List<Integer> result = Result.contacts(queries);
    System.out.println("*****" + result);
    for (int i = 0; i < result.size(); i++) {
      //            bufferedWriter.write(String.valueOf(result.get(i)));

      if (i != result.size() - 1) {
        //                bufferedWriter.write("\n");
      }
    }

    //        bufferedWriter.newLine();

    bufferedReader.close();
    //        bufferedWriter.close();
  }
}

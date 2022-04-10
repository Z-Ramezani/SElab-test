package gogoliiii.com;

import java.util.HashSet;
import java.util.Scanner;

public class left_nade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet s = new HashSet();
        String str = input.next();
        sub(str,s);
        int n=input.nextInt(), count = 0;
        for (int k = 0; k <n ; k++)
                if (s.contains(input.next())) count++;
            System.out.println(count);

    }
    public static void sub(String str, HashSet s){
        int i=0, j=1;
        while (i<str.length()){
            s.add(str.substring(i, j));
            j++;
            if (j==i+5 || j>str.length()){
                i++;
                j=i+1;
            }
        }
    }
}
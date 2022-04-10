//Test Branch
package gogoliiii.com;
import java.util.Arrays;
import java.util.Scanner;

public class binary_tree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        String n= input.next();
        for (int k = 0; k < m; k++) {
            String preorder = input.nextLine();
            n = input.nextLine();
            String pr[] = preorder.split(", ");
            pr[0]=pr[0].substring(1);
            int h= (int)(Math.log(pr.length)/Math.log(2));
            int node=(int)Math.pow(2,h);
            String in[]=new String[pr.length+1];
            in[1]=pr[0];
            int i=1;
            for (int j=1; j<pr.length;j++){
                if (2*i<in.length && in[2 * i] == null) {

                        in[2 * i] = pr[j];
                        i = 2 * i;

                }
                else if (2*i+1<in.length && in[2*i+1]==null){
                        in[2 * i + 1] = pr[j];
                        i = 2 * i + 1;
                }
                else {
                    i=i/2;
                    j--;
                    }
                }
            int[] inorder=new int[in.length];
            for (int j=1; j<in.length; j++)
                inorder[j] = Integer.parseInt(in[j]);
            int max[][]=new int[node][h+1];
            i=in.length-1;
            int y =0;
            for (int l=0; l<node; l++) {
                while (i >= 1 && y<=h) {
                    max[l][y] += inorder[i];
                    y++;
                    i /= 2;
                }
                i=in.length-1;
                i = i - 1-l;
                y=0;
            }
            y=0;
            int p=0, w=0;
            i=1;
            int[]fin=new int[((node)*(node-1))/2];
            while (p<node-1){
                if (max[p][y]==max[i][y])
                    fin[w]+=(max[p][y]);
                else {
                    fin[w]+=(max[i][y]);
                    fin[w]+=(max[p][y]);
                }
                y++;
                if (y==h+1){
                    y=0;
                    i++;
                    w++;
                }
                if (i==node){
                    p++;
                    i=p+1;
                }
            }
                Arrays.sort(fin);
            System.out.println(fin[fin.length-1]);
            }

    }
}

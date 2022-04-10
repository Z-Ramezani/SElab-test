package gogoliiii.com;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int preorder[] = new int[n];
        int inorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = input.nextInt();
        postorder( inorder, preorder, n);
    }

    static void postorder(int inorder[], int preorder[], int n) {
        int root = 0;
        for (int i = 0; i < n; i++)
            if (inorder[i] == preorder[0]) {
                 root = i;
            }

        if (root != 0)
            postorder(inorder, Arrays.copyOfRange(preorder, 1, n), root);

        if (root != n - 1)
            postorder(Arrays.copyOfRange(inorder, root + 1, n),
                    Arrays.copyOfRange(preorder, 1 + root, n), n - root - 1);

        System.out.print(preorder[0] + " ");
    }
}

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        boolean checkBST(Node root) {        
            return checkBST(root, -2147483648, 2147483647);
        }

        boolean checkBST(Node root, int min, int max){
            if (root == null) return true;
            if (root.data < min || root.data > max)
                return false;

            return checkBST(root.left, min, root.data - 1) &&
            checkBST(root.right, root.data + 1, max);
        }
    }
}

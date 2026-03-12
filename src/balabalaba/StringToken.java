package balabalaba;
import java.util.StringTokenizer;
public class StringToken {
public static void main(String[] args) {
        
        String phrase = "Programming is so cool!";
        
        StringTokenizer st = new StringTokenizer(phrase);
        
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}


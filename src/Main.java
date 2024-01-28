
import java.util.*;
import java.util.regex.*;
/*
    Discription:
                            <(.*?)>(.*?)</\\1>"

<:      	Matches the opening angle bracket < of the tag.

(.*?): 	    This is the first capturing group ( ), which matches the tag name. .*? matches any character (.) zero or more times (*), but in a non-greedy way (?).
            The non-greedy behavior ensures that it matches as few characters as possible 	until the next part of the pattern (>).

>: 	        Matches the closing angle bracket > of the opening tag.

(.*?): 	    This is the second capturing group ( ), which matches the content between the opening and closing tags. Similarly,
            .*? matches any character zero or more times in a non-greedy way.

</: 	    Matches the opening angle bracket < of the closing tag.

\\1: 	    This backreference matches the same text as the first capturing group (.*?). It ensures that the closing tag matches the opening tag.

>: 	        Matches the closing angle bracket > of the closing tag.
            So, altogether, the pattern "<(.*?)>(.*?)</\\1>" matches a pair of tags and captures the tag name and content between them.
            The .*? parts ensure that the pattern matches the smallest possible content between the tags, allowing us to handle nested tags effectively.
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            Pattern p = Pattern.compile("<(.+)>([^<]+)<(/\\1)>"); // a regex. this will catch the html tags
            Matcher m = p.matcher(line);

            boolean f = false;
            while (m.find()) {
                System.out.println(m.group(2));
                f = true;
            }

            if (!f) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}
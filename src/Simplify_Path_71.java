import java.util.Stack;

/**
 * Created by sunbo_000 on 10/3/2016.
 */
public class Simplify_Path_71 {


    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals(".")) continue;
            else if (p.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else if (!p.trim().equals("")) st.push(p);
        }
        StringBuilder resultSb = new StringBuilder();
        while (!st.isEmpty()) {
            resultSb.insert(0, "/" + st.pop());
        }
        return resultSb.length() == 0 ? "/" : resultSb.toString();
    }


    public static void main(String[] args) {
        Simplify_Path_71 solution = new Simplify_Path_71();
        solution.simplifyPath("///..");
    }
}

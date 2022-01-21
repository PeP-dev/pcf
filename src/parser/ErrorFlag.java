package parser;

/**
 * Created by noye on 16/01/2017.
 */
public class ErrorFlag {
    private static boolean errorFlag = false;
    private static String errorMsg = "Syntax error";
    public static void setFlag() {
        errorFlag = true;
    }
    public static void resetFlag() {
        errorFlag = false;
    }
    public static boolean getFlag() {
        return errorFlag;
    }
    public static void setMsg(String msg) {
        errorMsg = msg;
    }
    public static String getMsg() {
        return errorMsg;
    }
}

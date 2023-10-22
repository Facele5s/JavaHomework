package edu.hw2;

public class Task4 {
    private Task4() {

    }

    public static CallingInfo callingInfo() {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTraceElement = e.getStackTrace();
            String str = stackTraceElement[1].toString();
            str = str.substring(0, str.indexOf('('));

            String className = str.substring(0, str.lastIndexOf('.'));
            String methodName = str.substring(str.lastIndexOf('.') + 1);

            return new CallingInfo(className, methodName);
        }
    }

    public record CallingInfo(String className, String methodName) {

    }
}


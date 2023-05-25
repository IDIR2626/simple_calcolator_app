package com.example.calculator2;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator {
    public static String evaluate(String expression) {
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();
            Object result = rhino.evaluateString(scope, expression, "JavaScript", 1, null);
            if (String.valueOf(Context.toNumber(result)).endsWith(".0")){
                return String.valueOf(Context.toNumber(result)).replace(".0", "");
            }
            else {
                return String.valueOf(Context.toNumber(result));
            }

        } catch (Exception e) {
            return "Expression error";
        } finally {
            Context.exit();
        }
    }
}

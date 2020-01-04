package com.flyonsky.stack;

import java.util.Stack;

/**
 * 栈计算应用
 * @author luowengang
 * @date 2020/1/4 22:19
 */
public class CalcStack {

    private final static Character LEFT_ROUND_BRACKETS = '(';

    private final static Character RIGHT_ROUND_BRACKETS = ')';

    /**
     * 判断括号是否成对出现
     * @param expression 被判断的表达式
     * @return
     */
    public boolean validExpression(final String expression){
        boolean flag = true;
        Stack<Character> characterStack = new Stack<>();
        Character character = null;
        for(int i = 0; i< expression.length();i++){
            if(expression.charAt(i) == RIGHT_ROUND_BRACKETS){
                character = characterStack.pop();
                if(character.charValue() != LEFT_ROUND_BRACKETS){
                    flag = false;
                    break;
                }
            }else if(expression.charAt(i) == LEFT_ROUND_BRACKETS){
                characterStack.push(expression.charAt(i));
            }
        }
        if(flag && characterStack.empty()){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
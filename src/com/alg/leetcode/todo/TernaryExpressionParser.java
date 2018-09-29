/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo;

import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author rbara012
 * 
 Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. 
 You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.

* 
* Example 1:

Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:

Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:

Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"
          
* 
* 
 */
public class TernaryExpressionParser {
    /**
     * temporarily collect all the components of a single expression and process them
     * @param exp
     * @return 
     */
    public static String parseTernaryExpression(String exp){
        Stack<Character> st = new Stack<Character>();
        for(int i=exp.length()-1;i>=0;i--){
            //check if we have completed parsing an expression
            if(!st.isEmpty() && st.peek()=='?'){//we already have some elements in the stack so use them to evaluate the expression
                //get the elements pushed for this expression
                char ques = st.pop();//pop quest
                char val1 = st.pop();//pop the first value
                char col = st.pop();//pop the colon
                char val2 = st.pop();//pop the second value
                if(exp.charAt(i)=='T'){
                    st.push(val1);
                }else{
                    st.push(val2);
                }
            }else{
                st.push(exp.charAt(i));
            }
        }
        return String.valueOf(st.pop());
    }
    
    public static void main(String args[]){
        String exp ="T?5:3";
        System.out.println("result is:"+parseTernaryExpression(exp));
    }
}

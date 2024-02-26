package com.dsandalgo.ibmprep;

/*
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */


public class NewKeyboard {
	
    public static void main(String[] args) {
        
    	String S = "HE*<LL>O";
    	System.out.println(receivedText(S));
    	// expected output : LLHO
    }
    
    public static String receivedText(String S) {
    	System.out.println(S);
        char[] str = S.toCharArray();
        StringBuilder sb = new StringBuilder("");
        
        boolean isNumeric = true;
        int pos = 0;
        
        for (Character c : str) {
            
            if (c == '<') {
                // home key was pressed
                pos = 0;
                System.out.println("home key was pressed, pos = " + pos);
                
            } else if (c == '>') {
                // end key was pressed
                pos = sb.length();
                System.out.println("end key was pressed, pos = " + pos);
                
            } else if (c == '*') {
                // backspace was pressed
                sb.deleteCharAt(pos-1);
                --pos;
                System.out.println("backspace key was pressed, pos = " + pos);
                
            } else if (c == '#') {
                // numeric lock was pressed
                isNumeric = !isNumeric;
                System.out.println("numeric lock key was pressed, pos = " + pos);
                
            } else {
                // no special keys were pressed
                if (Character.isDigit(c) && isNumeric == false) {
                    // dont insert anything
                } else {
                    sb.insert(pos, c);
                    System.out.println("pos = " + pos + ", sb = " + sb);
                }
                
                pos++;
                System.out.println("New pos value = " + pos);
            }
        }
        return sb.toString();

    }
    
}

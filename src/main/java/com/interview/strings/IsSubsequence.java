package com.interview.strings;

/**
 * LeetCode 392 - Is Subsequence.
 * Determina si s es subsecuencia de t (mismo orden, no necesariamente consecutivo).
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();

        System.out.println(solution.isSubsequence("abc", "ahbgdc")); // esperado: true
        System.out.println(solution.isSubsequence("axc", "ahbgdc")); // esperado: false
        System.out.println(solution.isSubsequence("", "ahbgdc"));    // esperado: true
    }

    public boolean isSubsequence(String s, String t) {
        
        if(s.isEmpty()){
            return true;
        }
        char[] textS = s.toCharArray();
        char[] textT = t.toCharArray();
        int indiceEnS = 0;
        for(int i = 0; i < textT.length; i++){
            if(textS[indiceEnS]== textT[i]){
                indiceEnS++;
            }
        }
        return indiceEnS == s.length();
    }
}

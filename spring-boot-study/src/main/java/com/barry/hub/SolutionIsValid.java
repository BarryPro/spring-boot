package com.barry.hub;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionIsValid {
	public static void main(String[] args) {
		SolutionIsValid solutionIsValid = new SolutionIsValid();
		System.out.println(solutionIsValid.isValid("{{}}"));
	}

	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		if(charArray.length % 2 != 0){
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');
		Stack<Character> stack = new Stack<>();
		for (char c : charArray) {
			if('(' == c ||'[' == c||'{' == c){
				stack.push(c);
			} else {
				if(stack.isEmpty()){
					return false;
				}
				Character pop = stack.pop();
				if(map.get(pop) != c){
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}

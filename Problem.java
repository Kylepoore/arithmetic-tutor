import java.util.*;
class Problem{
private int[] numbers;
private int a;
private int b;
private int c;
private char operator;
private int solve;
private boolean solved;

public Problem(int a,char operator,int b,int c,int solve){
  this.a = a;
  this.b = b;
  this.c = c;
  this.solve = solve;
  this.operator = operator;
}

public ArrayList<Problem> getRelatedProblems(){
  ArrayList<Problem> problems = new ArrayList<Problem>();
  for(int i = 0; i < 3; i++){
    if (i == solve){
      continue;
    }
    problems.add(new Problem(a,operator,b,c,i));
  }

  switch(operator){
  case '+' :
    break;
  case '-' :
    break;
  case '*' :
    break;
  case '/' :
    break;
  }

  return problems;  
}

public String toString(){
  if(solved){
    return "" + a + " " + operator + " " + b + " = " + c;
  }else{
    switch(solve){
    case 0 :
      return "__ " + operator + " " + b + " = " + c;
    case 1 :
      return "" + a + " " + operator + " __ = " + c;
    case 2 :
      return "" + a + " " + operator + " " + b + " = __";
    default:
      return "Error: invalid problem";
    }
  }
}

public boolean check(int answer){
  int solution = 0;
  switch(solve){
  case 0 :
    solution = a;
    break;
  case 1 :
    solution = b;
    break;
  case 2 :
    solution = c;
    break;
  }
  solved = answer == solution;
  return solved;
}

}

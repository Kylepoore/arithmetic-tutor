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
  this.numbers = new int[3];
  this.numbers[0] = a;
  this.numbers[1] = b;
  this.numbers[2] = c;
  this.solve = solve;
  this.operator = operator;
}


public boolean tryValue(int value){
  int x = a;
  int y = b;
  int z = c;
  switch(solve){
  case 0:
    x = value;
    break;
  case 1:
    y = value;
    break;
  case 2:
    z = value;
    break;
  }

  switch(operator){
  case '+':
    return x + y == z;
  case '-':
    return x - y == z;
  case '*':
    return x * y == z;
  case '/':
    if(y == 0){
      System.out.println("You can not divide by 0 !");
      break;
    }
    return x / y == z;
  }
  return false;
}


public ArrayList<Problem> getRelatedProblems(){
  ArrayList<Problem> problems = new ArrayList<Problem>();
  for(int i = 0; i < 3; i++){
    if (i == solve) continue;
    //if(operator == '*' && i < 2 && c == 0) continue;
    problems.add(new Problem(a,operator,b,c,i));
  }

  switch(operator){
  case '+' :
    problems.add(new Problem(c,'-',a,b,0));
    problems.add(new Problem(c,'-',b,a,0));
    problems.add(new Problem(c,'-',a,b,1));
    problems.add(new Problem(c,'-',b,a,1));
    problems.add(new Problem(c,'-',a,b,2));
    problems.add(new Problem(c,'-',b,a,2));
    break;
  case '-' :
    problems.add(new Problem(c,'+',b,a,0));
    problems.add(new Problem(c,'+',b,a,1));
    problems.add(new Problem(c,'+',b,a,2));
    break;
  case '*' :
    if(a!=0){
      problems.add(new Problem(c,'/',a,b,0));
    //  if(c!=0){
        problems.add(new Problem(c,'/',a,b,1));
    //  }
      problems.add(new Problem(c,'/',a,b,2));
    }
    if(b!=0){
      problems.add(new Problem(c,'/',b,a,0));
    //  if(c!=0){
        problems.add(new Problem(c,'/',b,a,1));
    //  }
      problems.add(new Problem(c,'/',b,a,2));
    }
    break;
  case '/' :
    //if(b!=0){
      problems.add(new Problem(c,'*',b,a,0));
    //}
    //if(c!=0){
      problems.add(new Problem(c,'*',b,a,1));
    //}
    //if(c!=0 && b!=0){
      problems.add(new Problem(c,'*',b,a,2));
    //}
    break;
  }

  return problems;  
}

public String toString(){
  if(solved){
    return "" + a + " " + operator + " " + b + " = " + c;
  }else{
    String s = "------------------------------------\n\n";
    switch(solve){
    case 0 :
      s += "  __ " + operator + " " + b + " = " + c;
      break;
    case 1 :
      s += "  " + a + " " + operator + " __ = " + c;
      break;
    case 2 :
      s += "  " + a + " " + operator + " " + b + " = __";
      break;
    default:
      return "Error: invalid problem";
    }
    s += "\n\n------------------------------------";
    return s;
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
  boolean validAnswer = tryValue(answer);
  solved = answer == solution || validAnswer;



  return solved;
}

public void reset(){
  solved = false;
}

}

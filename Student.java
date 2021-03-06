import java.util.*;

class Student{


public final double TARGET_PERFORMANCE = 0.80;
public final double MIN_RATE = 0.80;
public final int MIN_LEVEL = 5;
public String name;
public double levelAdd = 15;
public double levelSub = 15;
public double levelMul = 10;
public double levelDiv = 10;
List<Problem> problems = new ArrayList<Problem>();

public Student(String name){
  this.name = name;
}

public void updateLevel(char type, double performance){
  double rate = Math.max(performance / TARGET_PERFORMANCE, MIN_RATE);
  switch (type) {
    case '+':
              levelAdd *= rate;
              levelAdd = Math.max(levelAdd,MIN_LEVEL);
    break;
    case '-': 
              levelSub *= rate; 
              levelSub = Math.max(levelSub,MIN_LEVEL);
    break;
    case '*': 
              levelMul *= rate; 
              levelMul = Math.max(levelMul,MIN_LEVEL);
    break;
    case '/': 
              levelDiv *= rate; 
              levelDiv = Math.max(levelDiv,MIN_LEVEL);
    break;
    default : 
  }
              
  
}

public void generateProblems(char type, int n, boolean related){
  for (int i = 0; i < 2*n; i++){
    int a;
    int b;
    int c;
    switch (type){
      case '+': 
                a = (int)(Math.random()*levelAdd);
                b = (int)(Math.random()*levelAdd);
                c = a + b;
      break;
      case '-': 
                a = (int)(Math.random()*levelSub);
                b = (int)(Math.random()*levelSub);
                c = a - b;
      break;
      case '*': 
                a = (int)(Math.random()*levelMul);
                b = (int)(Math.random()*levelMul);
                c = a * b;
      break;
      case '/': 
                b = (int)(Math.random()*(levelDiv-1))+1;
                c = (int)(Math.random()*levelDiv);
                a = b * c;
                c = a / b;
      break;
      default: System.exit(1);
               a=b=c=0;
    }
    Problem problem = new Problem(a,type,b,c,2);
    problems.add(problem);
    if(related){
      problems.addAll(problem.getRelatedProblems());
    }
  }
  Collections.shuffle(problems);
  problems = problems.subList(0,n);
}

}

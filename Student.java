import java.util.*;

class Student{

public String name;
public int age;
public int level = 0;
ArrayList<Problem> problems = new ArrayList<Problem>();

public Student(String name, int age){
  this.name = name;
  this.age = age;
}

public void generateProblems(char type){
  for (int i = 0; i < 5; i++){
    int a = (int)(Math.random()*1000);
    int b = (int)(Math.random()*1000);
    int c;
    switch (type){
      case '+': c = a + b;
      break;
      case '-': c = a - b;
      break;
      case '*': c = a * b;
      break;
      case '/': c = a / b;
      break;
      default: System.exit(1);
               c=0;
    }
    Problem problem = new Problem(a,type,b,c,2);
    problems.add(problem);
    problems.addAll(problem.getRelatedProblems());
  }
}










}

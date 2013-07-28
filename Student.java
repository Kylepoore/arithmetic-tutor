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

public void generateProblems(){
  for (int i = 0; i < 3; i++){
    int a = (int)(Math.random()*10);
    int b = (int)(Math.random()*10);
    int c = a + b;
    Problem problem = new Problem(a,'+',b,c,2);
    problems.add(problem);
    problems.addAll(problem.getRelatedProblems());
  }
}










}

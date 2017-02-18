import java.util.regex.*;
import java.util.*;
class Tutor{

public static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
public static final int MAX_PROBLEM_ATTEMPTS = 2;

public static void study(Student student){
  System.out.println("What would you like to study?");
  char op = ' ';
  do{
    System.out.print("(A)ddition, (S)ubtraction, (M)ultiplication, (D)ivision :");
    op = keyboard.next().toLowerCase().charAt(0);
    switch(op){
      case 'a': op = '+';
      break;
      case 's': op = '-';
      break;
      case 'm': op = '*';
      break;
      case 'd': op = '/';
      break;
      default : op = ' ';
    }
  }while(op == ' ');
  System.out.println("Okay, let's do some studying...");
  System.out.println("(press 'X' if you want to stop)");
  boolean loop = true;
  String input = "";
  int counter = 0;
  int countWrong = 0;
  int attempts = 0;
  int problemAttempts = 0;
  student.generateProblems(op,20);
  while(loop){
    if(counter >= student.problems.size()){
      System.out.println("Congratulations, we finished this set of problems!\n");
      student.updateLevel(op,1-(double)countWrong/attempts);
      System.out.printf("You answered %.2f%% of the problems correctly!\n\n", (1-(double)countWrong/attempts)*100);
      student.problems.clear();
      return;
    }
    Problem problem = student.problems.get(counter);
    System.out.println(problem);
    System.out.print("answer: ");
    while((input = keyboard.next()).equals(""))
        System.out.print("Sorry, I didn't understand your input\nanswer: ");
    if(input.toLowerCase().equals("x")){
      System.out.println("We'll study more later!\n");
      student.problems.clear();
      return;
    }
    int answer = 0;
    try{
      answer = Integer.parseInt(input);
    }catch(Exception e){
      System.out.println("Sorry, I didn't understand your input!");
      continue;
    }
    
    
    attempts++;
    problemAttempts++;

    boolean result = problem.check(answer);


    if(problem.check(answer)){
      System.out.println("Great job!! :)\n\n");
      counter++;
      problemAttempts = 0;
    }else if(problemAttempts >= MAX_PROBLEM_ATTEMPTS){
      System.out.println("uh-oh, looks like you got it wrong. :(\n\nDon't worry! you'll get to try again later!\n");
      List<Problem> related = problem.getRelatedProblems();
      related = related.subList(0,5);
      Collections.shuffle(related);
      student.problems.addAll(related);
      countWrong++;
      counter++;
      problemAttempts = 0;
    }else{
      System.out.println("try again! " + (MAX_PROBLEM_ATTEMPTS - problemAttempts) + " tries left.");
    }
  }
}

public static void menu(Student student){
  String input = "";
  boolean loop = true;
  String menuMsg = "What would you like to do?\n" +
                     "(T)est, (S)tudy, (Q)uit";
  while(loop){
    System.out.println(menuMsg);
    System.out.print(student.name + ">");
    input = keyboard.next().toLowerCase();
    if(input.equals("q")){
      loop = false;
    }else if(input.equals("?")){
      System.out.println(menuMsg);
    }else if(input.equals("")){
      continue;
    }else if(input.equals("s")){
      study(student);
    }else if(input.equals("t")){
      ;
    }else{
      System.out.println("I'm sorry, I didn't understand that");
      System.out.println(menuMsg);

    }

  }
  
}

public static void main(String[] args){
  String name = "Jeff";
  Student student;

  System.out.println("Math Tutor\n\n\n");
  
  System.out.println("Hi " + name + "!\n");
  System.out.println("Welcome Back!\n\n\n");



  student = new Student(name);
  
  menu(student);

}

}

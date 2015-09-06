import java.util.regex.*;
import java.util.*;
class Tutor{

public static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");


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
  student.generateProblems(op,3);
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
        System.out.print("Sorry, I didn't understand your input :(\n" + 
                            "answer: ");
    if(input.toLowerCase().equals("x")){
      System.out.println("We'll study some more later!\n");
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
    if(problem.check(answer)){
      System.out.println("Great job!! :)\n");
      counter++;
    }else{
      System.out.println("uh-oh, looks like you got it wrong. :(");
      countWrong++;
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
  String name;
  int age;
  Student student;

  System.out.println("Welcome to Math Tutor!\n");
  
  System.out.print("what is your name?\n>");
  name = keyboard.next();
  System.out.print("how old are you, " + name + " ?\n>");
  age = keyboard.nextInt();
  
  student = new Student(name,age);
  
  menu(student);

}

}

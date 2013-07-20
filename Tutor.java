import java.util.regex.*;
import java.util.*;
class Tutor{

public static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");


public static void study(Student student){
  System.out.println("Okay, let's do some studying...");
  System.out.println("(press 'X' when you want to stop)");
  boolean loop = true;
  String input = "";
  int counter = 0;
  student.generateProblems();
  while(loop){
    if(counter >= student.problems.size()){
      System.out.println("Congratulations, we finished this set of problems!\n");
      student.problems.clear();
      return;
    }
    Problem problem = student.problems.get(counter);
    System.out.println(problem.toString());
    System.out.print("answer: ");
    input = keyboard.next();
    if(input.toLowerCase().equals("x")){
      System.out.println("We'll study some more later!\n");
      return;
    }
    int answer = Integer.parseInt(input);
    if(problem.check(answer)){
      System.out.println("Great job!! :)\n" + problem.toString());
      counter++;
    }else{
      System.out.println("uh-oh, looks like you got it wrong. :(");
    }
  
  }
}

public static void menu(Student student){
  String input = "";
  boolean loop = true;
  System.out.println("What would you like to do?\n" +
                     "(T)est, (S)tudy, (Q)uit");
  while(loop){
    System.out.print(student.name + ">");
    input = keyboard.next().toLowerCase();
    if(input.equals("q")){
      loop = false;
    }else if(input.equals("?")){
      System.out.println("What would you like to do?\n" +
                         "(T)est, (S)tudy, (Q)uit");
    }else if(input.equals("")){
      continue;
    }else if(input.equals("s")){
      study(student);
    }else if(input.equals("t")){
      ;
    }else{
      System.out.println("I'm sorry, I didn't understand that");
      System.out.println("What would you like to do?\n" +
                         "(T)est, (S)tudy, (Q)uit");

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

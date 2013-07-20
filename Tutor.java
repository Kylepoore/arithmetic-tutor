import java.util.regex.*;
import java.util.*;
class Tutor{

public static Scanner keyboard = new Scanner(System.in).useDelimiter("\n");

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
      ;
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

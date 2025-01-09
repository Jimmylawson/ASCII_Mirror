package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input the file path: ");
        String filePath = in.nextLine();
        fileFunction(filePath);

//        System.out.println("            ^__^");
//        System.out.println("    _______/(oo)");
//        System.out.println("/\\/(       /(__)");
//        System.out.println("   | w----||    ");
//        System.out.println("   ||     ||    ");

    }

    static void fileFunction(String filePath){
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("File not found!");
            return;
        }else{
            try(Scanner fileScanner = new Scanner(file)){
                while(fileScanner.hasNextLine()){
                    list.add(fileScanner.nextLine());
                }
              int maxLength = 0;
                for(String line : list){
                    if(line.length() > maxLength){
                        maxLength = line.length();
                    }
                }

                for(String line : list){
                    String modifiedLine = String.format("%-" + maxLength + "s",line);
                    StringBuilder reversed = new StringBuilder();
                    for(int i = modifiedLine.length() - 1;i >=0;i--){
                        char c = modifiedLine.charAt(i);
                        switch (c){
                            case '<': reversed.append('>'); break;
                            case '>': reversed.append('<'); break;
                            case '[': reversed.append(']'); break;
                            case ']': reversed.append('['); break;
                            case '{': reversed.append('}'); break;
                            case '}': reversed.append('{'); break;
                            case '(': reversed.append(')'); break;
                            case ')': reversed.append('('); break;
                            case '/': reversed.append('\\'); break;
                            case '\\': reversed.append('/'); break;
                            default: reversed.append(c); // Keep other characters as is
                        }
                    }
                    String reversedModifiedLine = reversed.toString();
                    System.out.println(modifiedLine + " | " + reversedModifiedLine);
                }
            }catch(FileNotFoundException e){
                System.out.println("File not Found!");
            }



        }
    }
}
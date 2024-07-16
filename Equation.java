import java.util.Scanner;
import java.util.ArrayList;

public class Equation {
    private String equation;
    private int[][] bdEquation;
    private ArrayList<String> medEquation; //This represents a mediated form of an equation
    private ArrayList<Integer> values;
    private boolean[] negOrPos;
    int count = 0;

    public Equation(){
        System.out.println("Input an equation");
        Scanner sc = new Scanner(System.in);
        equation = sc.nextLine();
        for(int i = 0; i < equation.length(); i++){
            if(equation.substring(i, i + 1).equals("+") || equation.substring(i, i + 1).equals("-")){
                count++;
            }
        }
        if(equation.substring(0, 1).equals("-")){
            bdEquation = new int[3][count];
        }
        else {
            bdEquation = new int[3][count + 1];
        }
        //bdEquation = new int[3][count + 1];
        medEquation = new ArrayList<String>();
        values = new ArrayList<Integer>();
    }

    public void negativeOrPositive(){
        boolean first = true;
        int index = 0;
        for(int i = 0; i < equation.length(); i++){
            if(first){
                if(equation.substring(i, i + 1).equals("-")){
                    bdEquation[2][index] = -1;
                }
                else {
                    bdEquation[2][index] = 1;
                }
                first = false;
                index++;
            }
            else if(equation.substring(i, i + 1).equals("+")){
                bdEquation[2][index] = 1;
                index++;
            }
            else if(equation.substring(i, i + 1).equals("-")){
                bdEquation[2][index] = -1;
                index++;
            }
        }
    }

    public void medBD(){
        int start = 0;
        int stop = 0;
        int j = 1;
        String special = "";
        boolean first = true;
        negativeOrPositive();
        for(int i = 0; i < equation.length(); i++){
            if(first){
                if(equation.substring(i, i + 1).equals("-")){
                    i++;
                    start++;
                }
                else {
                    i--;
                }
                //first = false;
            }
            else {
                if(equation.substring(i, i + 1).equals("+") || equation.substring(i, i + 1).equals("-")){
                    medEquation.add(equation.substring(start, i));
                    start = i + 1;
                }
                else if(i == equation.length() - 1){
                    medEquation.add(equation.substring(start, i + 1));
                }
            }
            first = false;
        }

    }

    public int[][] breakDownEquation(){
        medBD();
        String coefficient = "";
        String power = "";
        int j = 0;
        for(int i = 0; i < medEquation.size(); i++){
            while(j < medEquation.get(i).length() && !(medEquation.get(i).substring(j, j + 1).equals("x"))){
                coefficient += medEquation.get(i).substring(j, j + 1);
                j++;
            }
            if(coefficient.length() < 1){
                bdEquation[0][i] = 1;
            }
            else {
                bdEquation[0][i] = Integer.parseInt(coefficient);

            }
            System.out.println(bdEquation[0][i]);
            if(j == medEquation.get(i).length()){
                System.out.println(true);
                bdEquation[1][i] = 0;
            }
            else if(medEquation.get(i).substring(j, j + 1).equals("x")){
                System.out.println(true);
                if(j < medEquation.get(i).length() - 1){
                    j += 2; //maybe 2
                    while(j < medEquation.get(i).length()){
                        power += medEquation.get(i).substring(j, j + 1);
                        j++;
                    }
                    bdEquation[1][i] = Integer.parseInt(power);
                }
                else {
                    bdEquation[1][i] = 1;
                }
                System.out.println(bdEquation[1][i]);
            }
            coefficient = "";
            power = "";
            j = 0;
        }
        System.out.println();
        System.out.println();
        System.out.println("This is the size " + medEquation.size());
        for(int i = 0; i < bdEquation.length; i++){
            for(int k = 0; k < bdEquation[0].length; k++){
                System.out.println(bdEquation[i][k] + " ");
            }
        }
        return bdEquation;
    }


}

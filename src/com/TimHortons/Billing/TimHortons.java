package com.TimHortons.Billing;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class TimHortons {
    ArrayList<HashMap<String,Double>> Tims = new ArrayList<HashMap<String,Double>>();
    public static void main(String[] args){
        TimHortons TimHortons = new TimHortons();
        TimHortons.start();
    }
    public void start(){
        DecimalFormat format=new DecimalFormat("##.00");
        HashMap<String,Double> Beverages = new HashMap<String, Double>(){{put("coffee",0.0);put("tea",0.0);}};
        HashMap<String,Double> Size = new HashMap<String, Double>(){{put("large",3.25);put("medium",2.50);put("small",1.50);}};
        Tims.add(Beverages);
        Tims.add(Size);
        Scanner scanIn = new Scanner(System.in);
        for(int j=0;j<6;j++){
            String flavour="";
            String output="";
            Double cost=0.0;
            int flag=1;
            if(Tims.size()>2){
                Tims.remove(2);
            };
            System.out.println("Welcome to Tim Hortons!");
            System.out.println("Enter your name:");
            output+="For "+scanIn.nextLine()+",a ";
            System.out.println("Enter your Beverage Selection(Coffee or Tea):");
            for(int i=0;i<Tims.size();i++){
                if(i==1){
                    System.out.println("Enter your Beverage Size:");
                }
                else if(i==2){
                    System.out.println("Enter Flavour:");
                };
                String input = scanIn.nextLine().toLowerCase();
                flavour=Finder(input,Tims.get(i));
                if(flavour == ""){
                    System.out.println("Invalid Entry");
                    flag=0;
                    break;
                };
                cost+=Tims.get(i).get(flavour);
                output+=flavour+" ";
            };
            if(flag==1){
                System.out.println(output+"Flavouring cost:$"+format.format(cost*1.13));
            };
        };
    }

    public String Finder(String input, HashMap<String,Double> value){
        String returnVal="";
        String part1="";
        HashMap<String,Double> Flavour1 = new HashMap<String, Double>(){{put("vanilla",0.25);put("chocolate",0.75);put("none",0.0);}};
        HashMap<String,Double> Flavour2 = new HashMap<String, Double>(){{put("lemon",0.25);put("mint",0.50);put("none",0.0);}};
        for (String key : value.keySet()) {
            try{
                String[] parts = key.split("");
                part1 = parts[0];
            }
            catch(Exception e){
                part1="";
            };
            if(input.equals(key) || input.equals(part1)){
                if(key.equals("coffee")){
                    Tims.add(Flavour1);
                }
                else if(key.equals("tea")){
                    Tims.add(Flavour2);
                }
                returnVal=key;
            }
        };
        return returnVal;
    }
}




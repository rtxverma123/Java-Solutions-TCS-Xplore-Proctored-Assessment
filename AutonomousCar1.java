import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution{

     public static void main(String []args){
         
         AutonomousCar [] carzz = new AutonomousCar[4];
         Scanner s = new Scanner(System.in);
         for(int i=0; i<carzz.length; i++){
             int carId= s.nextInt(); s.nextLine();
             String brand = s.nextLine();
	         int noOfTestsConducted =s.nextInt(); 
             int noOfTestsPassed =s.nextInt(); s.nextLine();
	         String environment = s.nextLine();
	         carzz[i] = new AutonomousCar (carId, brand, noOfTestsConducted, noOfTestsPassed, environment) ;
         }
         String envi = s.nextLine();
         String brand = s.nextLine();
         int output1 = findTestPassedByEnv(carzz, envi);
         if(output1 == 0){
             System.out.println("There are no tests passed in this particular environment");
         } else {
             System.out.println(output1);
         }
         AutonomousCar output2 = updateCarGrade(carzz, brand); 
         if(output2==null){
             System.out.println("No Car is available with the specified brand");
         } else {
             System.out.println(output2.getBrand()+"::"+output2.getGrade());
         }
        
     }
     public static int findTestPassedByEnv(AutonomousCar[] car, String environment){
         int sum=0;
         for(int i=0; i<car.length; i++){
             if(car[i].getEnvironment().equalsIgnoreCase(environment)){
                 sum = sum + car[i].getNoOfTestsPassed();
             }
         }
         return sum;
         
     }
     
     public static AutonomousCar updateCarGrade(AutonomousCar[] cars, String brand) {
     AutonomousCar cars1 = null;
     int rating;
     for(int i=0; i<cars.length; i++){
         if(cars[i].getBrand().equalsIgnoreCase(brand)){
      rating = ((cars[i].getNoOfTestsPassed())*100)/(cars[i].getNoOfTestsConducted() );
        if(rating >=80) {
            cars[i].setGrade("A1");
        } else cars[i].setGrade("B2");
            cars1=cars[i];
            return cars1;
            
         }
     }
     return null;
}
}


 class AutonomousCar {
	private int carId;
	private String brand;
	private int noOfTestsConducted;
	private int noOfTestsPassed;
	private String environment ;
	private String grade;
	
	public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.noOfTestsConducted = noOfTestsConducted;
		this.noOfTestsPassed = noOfTestsPassed;
		this.environment = environment;
	}

	 int getCarId() {
		return carId;
	}

	 void setCarId(int carId) {
		this.carId = carId;
	}

    String getBrand() {
		return brand;
	}

	 void setBrand(String brand) {
		this.brand = brand;
	}

	 int getNoOfTestsConducted() {
		return noOfTestsConducted;
	}

	 void setNoOfTestsConducted(int noOfTestsConducted) {
		this.noOfTestsConducted = noOfTestsConducted;
	}

	 int getNoOfTestsPassed() {
		return noOfTestsPassed;
	}

	void setNoOfTestsPassed(int noOfTestsPassed) {
		this.noOfTestsPassed = noOfTestsPassed;
	}

	 String getEnvironment() {
		return environment;
	}

	 void setEnvironment(String environment) {
		this.environment = environment;
	}

	 String getGrade() {
		return grade;
	}

	 void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}

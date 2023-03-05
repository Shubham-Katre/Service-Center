import java.util.*;

class Car{
    static final String Hatchback= "Hatchback"; 
    static final String Sedan= "Sedan";
    static final String SUV= "SUV";
}

class CarService {
  private String serviceCode;
  private String serviceName;
  
   HashMap<String,Integer> price;

  
  public CarService(String serviceCode, String serviceName, int hatchbackPrice, int sedanPrice, int suvPrice) {
    this.serviceCode = serviceCode;
    this.serviceName = serviceName;
    
    price=new HashMap<>();
    
    price.put(Car.Hatchback,hatchbackPrice);
    price.put(Car.Sedan,sedanPrice);
    price.put(Car.SUV,suvPrice);
    
  }
    
  
  public String getServiceCode() {
    return this.serviceCode;
  }
  
  public String getServiceName() {
    return this.serviceName;
  }
}
  class ServiceCenter{
      HashMap<String,CarService>services;
  
  ServiceCenter(){
      services=new HashMap<String,CarService>();
      
      services.put("BS01", new CarService ("BS01","Basic Servicing", 2000, 4000, 5000));
      services.put("EF01", new CarService ("EF01","Engine Fixing" , 5000 , 8000, 10000));
      services.put("CF01", new CarService ("CF01","Clutch Fixing", 2000, 4000, 6000));
      services.put("BF01", new CarService ("BF01","Brake Fixing", 1000, 1500, 2500));
      services.put("GF01",new CarService ("GF01","Gear Fixing", 3000, 6000, 8000));
     
  }
 
  public void calculatePrice(ArrayList<String>serviceCodes, String car) {
    int price = 0;
    for (String code:serviceCodes){
       CarService finalService=this.services.get(code);
       int finalPrice=finalService.price.get(car);
       price+=finalPrice;
       System.out.println("Price for "+ finalService.getServiceName()+ "-> RS " +finalPrice);
    }
    
    System.out.println("Total Amount - RS "+price);
    
    if (price>10000){
      System.out.println("Congratulation you got Complimentary Cleaning for Free");
    }
  }
  }
  
class Main{
	public static void main(String[] args) {
		ServiceCenter station= new ServiceCenter();
		ArrayList<String>list=new ArrayList<>();
		        list.add("CF01");
		        list.add("EF01");
            list.add("GF01");
		        
		        station.calculatePrice(list,Car.SUV);
		  
	}
}

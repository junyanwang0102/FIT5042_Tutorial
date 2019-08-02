package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.math.BigDecimal;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Jian
 */
public class RealEstateAgency {
    
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        // factory create an instance of propertyRepository
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    public void addProperty() throws Exception{
        this.propertyRepository.addProperty(new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia", 150, 420000.00));
        this.propertyRepository.addProperty(new Property(2, "11 Bettina St, Clayton VIC 3168, Australia", 352, 360000.00));
        this.propertyRepository.addProperty(new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163, Australia", 800, 650000.00));
        this.propertyRepository.addProperty(new Property(4, "3 Hamilton St, Bentleigh VIC 3204, Australia", 170, 435000.00));
        this.propertyRepository.addProperty(new Property(5, "82 Spring Rd, Hampton East VIC 3188, Australia", 60, 820000.00));
        System.out.println("5 properties added successfully");
    }
    
    public void displayPropertyDetail() throws Exception{
        for(Property p : this.propertyRepository.getAllProperties()){
            System.out.println(p.toString());
        }
    }
    
    public void searchProperty(int id) throws Exception{
        Property p = this.propertyRepository.searchPropertyById(id);
    }
    
    public static void cutLine(){
        System.out.println("*******************************************");
    }
    
    public int inputId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the property you want to search:");
        return sc.nextInt();    
    }
    
    
    public static void main(String[] args) throws Exception {
        RealEstateAgency rea = new RealEstateAgency("Andrew Agent");
        rea.addProperty();
        cutLine();
        rea.displayPropertyDetail();
        cutLine();
        rea.searchProperty(rea.inputId());
    }
    
}

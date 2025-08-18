//package utilities;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Properties;
//
//public class DataGenerator {
//
//    public static userData generateAndSaveUserData() {
//        userData user = new userData();
//        user.firstName = FakerUtils.getFirstName();
//        user.middleName = FakerUtils.getMiddleName();
//        user.lastName = FakerUtils.getLastName();
//        user.email = FakerUtils.getEmail();
//        user.mobile = FakerUtils.getMobile();
//        user.aadhaar = FakerUtils.getAadhar();
//        user.businessStatus = FakerUtils.getBusinessStatus();
//        user.gender = FakerUtils.getGender();
//        user.schemeType = FakerUtils.getSchemeType();
//
//        saveToProperties(user);
//        return user;
//    }
//
//    private static void saveToProperties(userData user) {
//        try {
//            String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/registrationData.properties";
//            OutputStream output = new FileOutputStream(filePath);
//
//            Properties prop = new Properties();
//            prop.setProperty("firstName", user.firstName);
//            prop.setProperty("middleName", user.middleName);
//            prop.setProperty("lastName", user.lastName);
//            prop.setProperty("email", user.email);
//            prop.setProperty("mobile", user.mobile);
//            prop.setProperty("aadhaar", user.aadhaar);
//            prop.setProperty("businessStatus", user.businessStatus);
//            prop.setProperty("gender", user.gender);
//            prop.setProperty("schemeType", user.schemeType);
//
//            prop.store(output, null);
//            System.out.println("✅ Properties updated at: " + filePath);
//            output.close();
//        } catch (Exception e) {
//            System.err.println("❌ Error writing properties file: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
////
////package utilities;
////
////import java.io.FileOutputStream;
////import java.io.OutputStream;
////import java.util.Properties;
////
////public class DataGenerator {
////
////    public static userData generateAndSaveUserData() {
////        userData user = new userData();
////        user.firstName = FakerUtils.getFirstName();
////        user.middleName = FakerUtils.getMiddleName();
////        user.lastName = FakerUtils.getLastName();
////        user.email = FakerUtils.getEmail();
////        user.mobile = FakerUtils.getMobile();
////        user.aadhaar = FakerUtils.getAadhar();
////        user.businessStatus = FakerUtils.getBusinessStatus();
////        user.gender = FakerUtils.getGender();
////        user.schemeType = FakerUtils.getSchemeType();
////        
////        // Personal Details
//////        user.dateofBirth = FakerUtils.getDateOfBirth();
//////        user.guardianName = FakerUtils.getGuardianName();
//////        user.guardianType = FakerUtils.getGuardianType();
//////        user.disability = FakerUtils.getDisability();
//////        user.address = FakerUtils.getAddress();
//////        user.cityType = FakerUtils.getCityType();
//////        user.panchayat = FakerUtils.getPanchayat();
//////        user.policeStation = FakerUtils.getPoliceStation();
//////        user.district = FakerUtils.getDistrict();
//////        user.block = FakerUtils.getBlock();
//////        user.pin = FakerUtils.getPinCode();
//////        user.category = FakerUtils.getCategory();
//////        user.caste = FakerUtils.getCaste();
////    
////
////        saveToProperties(user);
////        return user;
////    }
////
////    private static void saveToProperties(userData user) {
////        try (OutputStream output = new FileOutputStream("src/test/resources/testdata/registrationData.properties")) {
////            Properties prop = new Properties();
////            prop.setProperty("firstName", user.firstName);
////            prop.setProperty("middleName", user.middleName);
////            prop.setProperty("lastName", user.lastName);
////            prop.setProperty("email", user.email);
////            prop.setProperty("mobile", user.mobile);
////            prop.setProperty("aadhaar", user.aadhaar);
////            prop.setProperty("businessStatus", user.businessStatus);
////            prop.setProperty("gender", user.gender);
////            prop.setProperty("schemeType", user.schemeType);
////            //prop.setProperty("password", user.password);
////            
////            // Personal details
//////            prop.setProperty("dateofBirth", user.dateofBirth);
//////            prop.setProperty("guardianName", user.guardianName);
//////            prop.setProperty("guardianType", user.guardianType);
//////            prop.setProperty("disability", user.disability);
//////            prop.setProperty("address", user.address);
//////            prop.setProperty("cityType", user.cityType);
//////            prop.setProperty("panchayat", user.panchayat);
//////            prop.setProperty("policeStation", user.policeStation);
//////            prop.setProperty("district", user.district);
//////            prop.setProperty("block", user.block);
//////            prop.setProperty("pin", user.pin);
//////            prop.setProperty("category", user.category);
//////            prop.setProperty("caste", user.caste);
//////            
////          prop.store(output, null);
////          System.out.println("✅ Properties updated at: " + filePath);
////          output.close();
////      } catch (Exception e) {
////          System.err.println("❌ Error writing properties file: " + e.getMessage());
////          e.printStackTrace();
////      }
////  }
////}
//
//

package utilities;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Properties;


public class DataGenerator {

    public static userData generateUserData() {
        userData user = new userData();
        user.firstName = FakerUtils.getFirstName();
        user.middleName = FakerUtils.getMiddleName();
        user.lastName = FakerUtils.getLastName();
        user.email = FakerUtils.getEmail();
        user.mobile = FakerUtils.getMobile();
        user.aadhaar = FakerUtils.getAadhar();
        user.businessStatus = FakerUtils.getBusinessStatus();
        user.gender = FakerUtils.getGender();
        user.schemeType = FakerUtils.getSchemeType();

       // Personal Details
        user.dateofBirth = FakerUtils.getDateOfBirth();
        user.guardianName = FakerUtils.getGuardianName();
        user.guardianType = FakerUtils.getGuardianType();
        user.disability = FakerUtils.getDisability();
        user.address = FakerUtils.getAddress();
        user.cityType = FakerUtils.getCityType();
        user.panchayat = FakerUtils.getPanchayat();
        user.policeStation = FakerUtils.getPoliceStation();
        user.district = FakerUtils.getDistrict(); // Fetch district first
        user.block = FakerUtils.getBlock(user.district); // Pass district to get corresponding block
        user.pin = FakerUtils.getPinCode();
        user.category = FakerUtils.getCategory();
        user.caste = FakerUtils.getCaste(user.category);
        

        // Education Details
        user.className = FakerUtils.getClassName();         
        user.boardName = FakerUtils.getRandomBoard();       
        user.boardrollNumber = FakerUtils.getRollNumber();  
        user.passingYear = FakerUtils.getPassingYear();     
        user.subjectName = FakerUtils.getRandomSubject(); 
        
        // Utilization Certificate
        user.supplierDetails = FakerUtils.getSupplierDetails();
        user.supplierGst     = FakerUtils.getSupplierGSTNumber();
        user.supplierBill    = FakerUtils.getSupplierBillNumber();
        user.machineName     = FakerUtils.getMachineName();
        user.machineCost     = FakerUtils.getMachineCost();
        
        String basePath = Paths.get("src/test/resources/testfiles").toAbsolutePath().toString();

        user.utilizationCertificatePath = Paths.get(basePath, "Utilization-Certificate.pdf").toString();
        user.machineToolsPath = Paths.get(basePath, "Machinetools photo.jpg").toString();
        user.shedPhotoPath = Paths.get(basePath, "shed photo.jpg").toString();						

        
        return user;
    }

    public static void saveToProperties(userData user) {
        try (OutputStream output = new FileOutputStream("src/test/resources/testdata/registrationData.properties")) {
            Properties prop = new Properties();
            prop.setProperty("firstName", user.firstName);
            prop.setProperty("middleName", user.middleName);
            prop.setProperty("lastName", user.lastName);
            prop.setProperty("email", user.email);
            prop.setProperty("mobile", user.mobile);
            prop.setProperty("aadhaar", user.aadhaar);
            prop.setProperty("businessStatus", user.businessStatus);
            prop.setProperty("gender", user.gender);
            prop.setProperty("schemeType", user.schemeType);
            prop.setProperty("dateofBirth", user.dateofBirth);
            prop.setProperty("guardianName", user.guardianName);
            prop.setProperty("guardianType", user.guardianType);
            prop.setProperty("disability", user.disability);
            prop.setProperty("address", user.address);
            prop.setProperty("cityType", user.cityType);
            prop.setProperty("panchayat", user.panchayat);
            prop.setProperty("policeStation", user.policeStation);
            prop.setProperty("district", user.district);
            prop.setProperty("block", user.block);
            prop.setProperty("pin", user.pin);
            prop.setProperty("category", user.category);
            prop.setProperty("caste", user.caste);
            
            // Education Info
            prop.setProperty("className", user.className);
            prop.setProperty("boardName", user.boardName);
            prop.setProperty("boardrollNumber", user.boardrollNumber);
            prop.setProperty("passingYear", user.passingYear);
            prop.setProperty("subjectName", user.subjectName);
            
            
            // UC Page
            prop.setProperty("supplierDetails", user.supplierDetails);
            prop.setProperty("supplierGst", user.supplierGst);
            prop.setProperty("supplierBill", user.supplierBill);
            prop.setProperty("machineName", user.machineName);
            prop.setProperty("machineCost", user.machineCost);
            

            prop.store(output, null);
            System.out.println("✅ Data saved to properties file.");
        } catch (Exception e) {
            System.err.println("❌ Failed to save registration data: " + e.getMessage());
        }
    }
}


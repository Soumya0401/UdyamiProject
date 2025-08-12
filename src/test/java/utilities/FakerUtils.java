//package utilities;
//
//import com.github.javafaker.Faker;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
//public class FakerUtils {
//    private static final Faker faker = new Faker();
//    private static final Random random = new Random();
//
//    public static String getFirstName() {
//        return faker.name().firstName();
//    }
//
//    public static String getMiddleName() {
//        String[] parts = faker.name().nameWithMiddle().split(" ");
//        return parts.length >= 2 ? parts[1] : "";
//    }
//
//    public static String getLastName() {
//        return faker.name().lastName();
//    }
//
//    public static String getEmail() {
//        return faker.internet().emailAddress();
//    }
//
//    public static String getMobile() {
//        return "9" + faker.number().digits(9);
//    }
//
//    public static String getAadhar() {
//        return faker.number().digits(12);
//    }
//
//    public static String getBusinessStatus() {
//        return random.nextBoolean() ? "Yes" : "No";
//    }
//
//    public static String getGender() {
//        String[] genders = {"पुरुष", "स्त्री", "अन्य"};
//        return genders[random.nextInt(genders.length)];
//    }
//
//    public static String getSchemeType() {
//        String[] schemes = {
//            "CM EBC Udyami yojna", 
//            "CM Mahila Udyami yojna", 
//            "CM MI Udyami yojna", 
//            "CM SCST Udyami yojna",
//            "CM Yuva Udyami yojna"
//        };
//        return schemes[random.nextInt(schemes.length)];
//    }
//    
//    public static String getDateOfBirth() {
//        Date dob = faker.date().birthday(18, 45);
//        return new SimpleDateFormat("dd/MM/yyyy").format(dob);
//    }
//
//    public static String getGuardianName() {
//        return faker.name().fullName();
//    }
//
//    public static String getGuardianType() {
//        String[] types = {"पिता", "माता", "पति", "अभिभावक"};  // Must match the HTML input values exactly
//        return types[random.nextInt(types.length)];
//    }
//
//
//    public static String getDisability() {
//        return random.nextBoolean() ? "No" : "Yes";
//    }
//
//    public static String getAddress() {
//        return faker.address().streetName();
//    }
//
//    public static String getCityType() {
//        String[] types = {"नगर परिषद", "नगर पंचायत", "ग्राम"};
//        return types[random.nextInt(types.length)];
//    }
//
//    public static String getPanchayat() {
//        return faker.address().cityName();
//    }
//
//    public static String getPoliceStation() {
//        return faker.address().lastName();
//    }
//
//    public static String getDistrict() {
//        String[] districts = {
//            "Araria", "Arwal", "Aurangabad", "Banka", "Begusarai", "Bhagalpur", "Bhojpur",
//            "Buxar", "Darbhanga", "East Champaran (Motihari)", "Gaya", "Gopalganj", "Jamui",
//            "Jehanabad", "Kaimur (Bhabua)", "Katihar", "Khagaria", "Kishanganj", "Lakhisarai",
//            "Madhepura", "Madhubani", "Munger", "Muzaffarpur", "Nalanda", "Nawada",
//            "Patna", "Purnia (Purnea)", "Rohtas", "Saharsa", "Samastipur", "Saran",
//            "Sheikhpura", "Sheohar", "Sitamarhi", "Siwan", "Supaul", "Vaishali", "West Champaran"
//        };
//        return districts[random.nextInt(districts.length)];
//    }
//
//
//    public static String getBlock() {
//        String[] blocks = {"Block A", "Block B", "Block C", "Block D"};
//        return blocks[random.nextInt(blocks.length)];
//    }
//
//    public static String getPinCode() {
//        return faker.number().digits(6);
//    }
//
//    public static String getCategory() {
//        String[] categories = {"GEN", "OBC", "SC", "ST", "EWS"};
//        return categories[random.nextInt(categories.length)];
//    }
//
//    public static String getCaste() {
//        return faker.name().lastName();
//    }
//}

package utilities;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.*;

public class FakerUtils {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Map<String, List<String>> districtBlockMap = new HashMap<>();

    static {
        districtBlockMap.put("Araria", Arrays.asList("Araria", "Forbesganj", "Jokihat"));
        districtBlockMap.put("Arwal", Arrays.asList("Arwal", "Kaler", "Kurtha"));
        districtBlockMap.put("Aurangabad", Arrays.asList("Aurangabad", "Daudnagar", "Kutumba"));
        districtBlockMap.put("Banka", Arrays.asList("Banka", "Amarpur", "Belhar"));
        districtBlockMap.put("Begusarai", Arrays.asList("Begusarai", "Bachhwara", "Teghra"));
        districtBlockMap.put("Bhagalpur", Arrays.asList("Nathnagar", "Kahalgaon", "Pirpainti"));
        districtBlockMap.put("Bhojpur", Arrays.asList("Koilwar", "Jagdishpur", "Sandesh"));
        districtBlockMap.put("Buxar", Arrays.asList("Buxar", "Dumraon", "Rajpur"));
        districtBlockMap.put("Darbhanga", Arrays.asList("Darbhanga", "Bahadurpur", "Benipur"));
        districtBlockMap.put("East Champaran", Arrays.asList("Motihari", "Raxaul", "Chakia(Pipra)"));
        districtBlockMap.put("Gaya", Arrays.asList("Bodh Gaya", "Belaganj", "Gaya Town C.D.Block"));
        districtBlockMap.put("Gopalganj", Arrays.asList("Gopalganj", "Kuchaikote", "Bhore"));
        districtBlockMap.put("Jamui", Arrays.asList("Jamui", "Dumri", "Chakai"));
        districtBlockMap.put("Jehanabad", Arrays.asList("Jehanabad", "Makhdumpur", "Ghoshi"));
        districtBlockMap.put("Kaimur", Arrays.asList("Bhabua", "Chainpur", "Mohania"));
        districtBlockMap.put("Katihar", Arrays.asList("Katihar", "Barsoi", "Manihari"));
        districtBlockMap.put("Khagaria", Arrays.asList("Khagaria", "Mansi", "Beldaur"));
        districtBlockMap.put("Kishanganj", Arrays.asList("Kishanganj", "Bahadurganj", "Thakurganj"));
        districtBlockMap.put("Lakhisarai", Arrays.asList("Lakhisarai", "Surajgarha", "Barahiya"));
        districtBlockMap.put("Madhepura", Arrays.asList("Madhepura", "Murliganj", "Shankarpur"));
        districtBlockMap.put("Madhubani", Arrays.asList("Harlakhi", "Benipatti", "Jhanjharpur"));
        districtBlockMap.put("Munger", Arrays.asList("Munger", "Tarapur", "Kharagpur"));
        districtBlockMap.put("Muzaffarpur", Arrays.asList("Muzaffarpur", "Kanti", "Sakra"));
        districtBlockMap.put("Nalanda", Arrays.asList("Rajgir", "Asthawan", "Hilsa"));
        districtBlockMap.put("Nawada", Arrays.asList("Nawada", "Hisua", "Gobindpur"));
        districtBlockMap.put("Patna", Arrays.asList("Patna", "Bakhtiarpur", "Maner"));
        districtBlockMap.put("Purnia", Arrays.asList("Purnia", "Banmankhi", "Dhamdaha"));
        districtBlockMap.put("Rohtas", Arrays.asList("Dehri", "Sasaram", "Chenari"));
        districtBlockMap.put("Saharsa", Arrays.asList("Saharsa", "Simri Bakhtiyarpur", "Sonbarsa"));
        districtBlockMap.put("Samastipur", Arrays.asList("Dalsinghsarai", "Rosera", "Samastipur"));
        districtBlockMap.put("Saran", Arrays.asList("Chhapra", "Manjhi", "Dighwara"));
        districtBlockMap.put("Sheikhpura", Arrays.asList("Sheikhpura", "Chewara", "Barbigha"));
        districtBlockMap.put("Sheohar", Arrays.asList("Sheohar", "Dumri Katsari", "Piprahi"));
        districtBlockMap.put("Sitamarhi", Arrays.asList("Sitamarhi", "Runisaidpur", "Majorganj"));
        districtBlockMap.put("Siwan", Arrays.asList("Siwan", "Maharajganj", "Goriakothi"));
        districtBlockMap.put("Supaul", Arrays.asList("Supaul", "Basantpur", "Tribeniganj"));
        districtBlockMap.put("Vaishali", Arrays.asList("Hajipur", "Mahua", "Bidupur"));
        districtBlockMap.put("West Champaran", Arrays.asList("Bettiah", "Bagaha", "Gaunaha"));
    }
    
    public static Map<String, List<String>> categoryCasteMap = new HashMap<>();

    static {
       categoryCasteMap.put("अनुसूचित जाति (SC)", Arrays.asList("बेडिया", "बंजारा", "गोंड", "करमाली"));
       categoryCasteMap.put("अनुसूचित जनजाति (ST)", Arrays.asList("बिरजिया", "बिरहोर", "खरवार", "कोल"));
        categoryCasteMap.put("सामान्य वर्ग (General)", Arrays.asList("भूमिहार", "राजपूत", "ब्राह्मण", "मुस्लिम"));
        //categoryCasteMap.put("अन्य पिछड़ा वर्ग (OBC)", Arrays.asList("घटवार", "कुशवाहा (कोईरी)", "घटवार", "परथा"));
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getMiddleName() {
        String[] parts = faker.name().nameWithMiddle().split(" ");
        return parts.length >= 2 ? parts[1] : "";
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getMobile() {
        return "9" + faker.number().digits(9);
    }

    public static String getAadhar() {
        return faker.number().digits(12);
    }

    public static String getBusinessStatus() {
        return random.nextBoolean() ? "Yes" : "No";
    }

    public static String getGender() {
        String[] genders = {"पुरुष", "स्त्री", "अन्य"};
        return genders[random.nextInt(genders.length)];
    }

    public static String getSchemeType() {
        String[] schemes = {
            "CM EBC Udyami yojna", 
            "CM Mahila Udyami yojna", 
            "CM MI Udyami yojna", 
            "CM SCST Udyami yojna",
            "CM Yuva Udyami yojna"
        };
        return schemes[random.nextInt(schemes.length)];
    }
    
    public static String getCategory() {
        String[] categories = {
            "अनुसूचित जाति (SC)",
            "अनुसूचित जनजाति (ST)",
            "सामान्य वर्ग (General)",
           // "अन्य पिछड़ा वर्ग (OBC)"
        };
        return categories[random.nextInt(categories.length)];
    }

    public static String getDateOfBirth() {
        Date dob = faker.date().birthday(18, 45);
        return new SimpleDateFormat("dd/MM/yyyy").format(dob);
    }

    public static String getGuardianName() {
        return faker.name().fullName();
    }

    public static String getGuardianType() {
        String[] types = {"पिता", "माता", "पति", "अभिभावक"};
        return types[random.nextInt(types.length)];
    }

    public static String getDisability() {
        return random.nextBoolean() ? "No" : "Yes";
    }

    public static String getAddress() {
        return faker.address().streetName();
    }

    public static String getCityType() {
        String[] types = {"नगर परिषद", "नगर पंचायत", "ग्राम"};
        return types[random.nextInt(types.length)];
    }

    public static String getPanchayat() {
        return faker.address().cityName();
    }

    public static String getPoliceStation() {
        return faker.address().lastName();
    }

    public static String getDistrict() {
        List<String> districts = new ArrayList<>(districtBlockMap.keySet());
        return districts.get(random.nextInt(districts.size()));
    }

    public static String getBlock(String district) {
        List<String> blocks = districtBlockMap.get(district);
        if (blocks == null || blocks.isEmpty()) {
            return "Block Not Found";
        }
        return blocks.get(random.nextInt(blocks.size()));
    }

    public static String getPinCode() {
        return faker.number().digits(6);
    }

    public static String getCaste(String category) {
        List<String> castes = categoryCasteMap.get(category);
        if (castes != null && !castes.isEmpty()) {
            return castes.get(random.nextInt(castes.size()));
        }
        return "अन्य";
    }
    public static String getRandomBoard() {
        String[] boards = {"CBSE", "BSEB", "ICSE", "NIOS"};
        return boards[random.nextInt(boards.length)];
    }

    public static String getRollNumber() {
        return faker.number().digits(10);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "Science", "English", "Social Science", "Hindi"};
        return subjects[random.nextInt(subjects.length)];
    }

    // ✅ Newly Added Methods
    public static String getClassName() {
        int classNumber = 1 + random.nextInt(12); // 1 to 12
        return "Class " + classNumber;
    }

    public static String getPassingYear() {
        int year = 1990 + random.nextInt(30); // 1990 to 2024
        return String.valueOf(year);
    }
    
    public static String getSupplierDetails() {
        String[] supplier = {"ABC PVT LTD", "M/s Bharat Machinery Works", "Global Tech Supplies"
        		,"Shree Engineering Co."};
        return supplier[random.nextInt(supplier.length)];
    }
    
    public static String getSupplierGSTNumber() {
        String[] gstNumbers = {
            "10ABCDE1234F1Z5",
            "27GHJKL5678K2Z6",
            "07MNOPQ9876L3Z7",
            "19XYZAB3456M4Z8"
        };
        return gstNumbers[random.nextInt(gstNumbers.length)];
    }

    public static String getSupplierBillNumber() {
        String[] billNumbers = {
            "BILL-00123",
            "INV-45678",
            "SUP-202309",
            "BILL-99887"
        };
        return billNumbers[random.nextInt(billNumbers.length)];
    }

    public static String getMachineName() {
        String[] machineNames = {
            "Hydraulic Press Machine",
            "CNC Lathe Machine",
            "Welding Machine",
            "Automatic Packing Machine"
        };
        return machineNames[random.nextInt(machineNames.length)];
    }

    public static String getMachineCost() {
        String[] machineCosts = {
            "120000", "250000", "185000", "310000"
        };
        return machineCosts[random.nextInt(machineCosts.length)];
    }
    
}

   
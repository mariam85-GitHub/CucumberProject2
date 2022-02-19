package texts;

import java.util.ArrayList;
import java.util.List;

public class ExpectedTextUserInformation {

    public static final String customerName = "Mariam Mohammad";
    public static final String address = "11624 s Natchez Ave";
    public static final String city = "worth";
    public static final String state = "IL";
    public static final String zipCode = "60482";
    public static final String creditCardNum = "1234 5678 9999";
    public static final String expireDate = "09/28";

    public static List<String> info = new ArrayList<>();
    public static List<String> userInfo(){
        info.add(customerName);
        info.add(address);
        info.add(city);
        info.add(state);
        info.add(zipCode);
        info.add(creditCardNum);
        info.add(expireDate);
        return info;
    }
}
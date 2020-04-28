package Demo;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyLocalization {
    public static void main(String[] args) {
       String lang="hi";
       String country="IN";
       Locale locale=new Locale(lang,country);
       ResourceBundle resourceBundle=ResourceBundle.getBundle("Demo/Bundle",locale);
       String output= resourceBundle.getString("HappyBirthday");
        System.out.println(output);
    }
}

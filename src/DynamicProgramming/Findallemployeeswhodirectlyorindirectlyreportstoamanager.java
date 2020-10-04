package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|Findallemployeeswhodirectlyorindirectlyreportstoamanager| on Sep,2020
 *  
 * Happy Coding :)
 **/

import java.util.*;

public class Findallemployeeswhodirectlyorindirectlyreportstoamanager {
    public static void findEmployees(Map<Character, Character> employeeToManagerMappings) {
        HashSet<Character> managers = new HashSet<>();
        int managerCount = 0;
        for (Map.Entry<Character, Character> x : employeeToManagerMappings.entrySet()) {
            managers.add(x.getValue());
        }
        managerCount = managers.size();

        for (int i = 0; i < managerCount; i++) {



        }

    }
}

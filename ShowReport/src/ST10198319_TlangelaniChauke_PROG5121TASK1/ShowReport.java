package ST10198319_TlangelaniChauke_PROG5121TASK1;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShowReport {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        String[] developers={"Bill","Cash","Joyce","Peter"};
        String[] tNames={"Benz","Gaming","Mansion","Mobile"};
        Arrays.sort(tNames);
        int[] tDuration={2,4,6,8};
        String[] tStatus={"Doing","Doing","Done","To-DO"};

        String option = JOptionPane.showInputDialog("Option 1: Display details of all tasks with the status Done\n" +
                "Option 2: View developer and duration of class with longest duration\n" +
                "Option 3: Search for tasks by task name\n" +
                "Option4: Search for tasks by developer name\n" +
                "Option5: Delete task using task name\n" +
                "Option6: Display report of all captured tasks");

        if(option.equals("1")) {
            JOptionPane.showMessageDialog(null,statusOfDone(developers, tNames, tDuration));
        }
        if(option.equals("2")) {
            JOptionPane.showMessageDialog(null,Duration(developers, tDuration));
        }
        if(option.equals("3")) {
            System.out.println("Enter search value(TaskName): ");
            JOptionPane.showMessageDialog(null,SearchByTaskName(developers, tNames, tStatus));
        }
        if(option.equals("4")) {
            System.out.println("Enter developer name: ");
            JOptionPane.showMessageDialog(null,AllTasksSearch(developers, tNames, tStatus));
        }
        if(option.equals("5")) {
            System.out.println("Enter the task name you want to delete: ");
            JOptionPane.showMessageDialog(null,deletion(tNames));
        }
    }
    public static String statusOfDone(String[] developers, String[] tNames, int[] tDuration){

        return developers[2] +" "+
                tNames[2] +" "+
                tDuration[2];
    }
    public static String Duration(String[] developers, int[] tDuration){

        int longest = tDuration[0];
        String name = null;
        for (int i =0;i<tDuration.length;i++){
            if(longest<tDuration[i]){
                longest = tDuration[i];
                if(tDuration[i] == longest){
                    name = developers[i];
                }
            }
        }

        return name +" is the developer with the longest duration which is "+ longest;
    }
    public static String SearchByTaskName(String[] developers, String[] tName,String[] tStatus){
        String searchValue= scan.next();

        String display = "The name of the developer is:  "+developers[Arrays.binarySearch(tName,searchValue)] +" "+
                "the task is: "+ tName[Arrays.binarySearch(tName,searchValue)] +" "+
                "and the status is:" +tStatus[Arrays.binarySearch(tName,searchValue)];

    return display;
    }
    public static String AllTasksSearch(String[] developers, String[] tName,String[] tStatus){

        String searchDeveloper= scan.next();

        String results = " Task name(s): "+ tName[Arrays.binarySearch(developers,searchDeveloper)]+" "+
                "and the status is: " +tStatus[Arrays.binarySearch(developers,searchDeveloper)];

        return results;
    }
    public static String deletion(String[] tName){
        List<String> list =Arrays.asList(tName);
        String delete=scan.next();
        list.remove(Arrays.asList(delete));
        tName=list.toArray(tName);

        return "Entry "+delete +" successfully deleted";
    }
    public static String DisplayAll(String Names, String[] tNames, int[] tDuration,String[] tStatus){

        return "Task Status: " + tStatus
                + "\nDeveloper Details: " + Names
                + "\nTask name: " + tNames
                + "\n Task duration: " + tDuration + "hours" ;
    }
}

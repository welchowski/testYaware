package Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class StaffBuilder {
    static File csvFile;
    public static String pathFile="C:\\Users\\Public\\data\\staffData.csv";

    public void builderCVS() {
        initializationArray();
        try {
            initializationCSVfile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Scanner scan;

    //for randon func
    static int min = 0;
    static int max = 19;
    static int diff = max - min;
    static int i;
    static Random random = new Random();

    static String[] nameMale = new String[20];
    static String[] lastNameMale = new String[20];
    static String[] nameFemale = new String[20];
    static String[] lastNameFemale = new String[20];
    static String[] email = new String[20];
    static String[] groupName = new String[20];

    static void openFile(String str) {
        try {
            scan = new Scanner(new File("data//" + str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void readFile(String[] str) {
        while (scan.hasNext()) {
            for (int row = 0; row < 20; row++) {
                str[row] = scan.next();
            }
        }
    }

    static void initializationArray() {
        openFile("email");
        readFile(email);

        openFile("groupName");
        readFile(groupName);

        openFile("lastNameFemale");
        readFile(lastNameFemale);

        openFile("lastNameMale");
        readFile(lastNameMale);

        openFile("nameFemale");
        readFile(nameFemale);

        openFile("nameMale");
        readFile(nameMale);
    }

    static int randomNumber() {
        i = random.nextInt(diff + 1);
        return i += min;
    }

    static void initializationCSVfile() throws FileNotFoundException {
        csvFile = new File(pathFile);
        PrintWriter out = new PrintWriter(csvFile);
        String nameColumns = "firstname,lastname,email,group_name";

        //adding name for colums
        out.println(nameColumns);

        //adding  random data to csv
        for (int i = 0; i < 10; i++) {
            if (i > 4) {//female
                out.printf("%s,%s,%s,%s\n",
                        nameFemale[randomNumber()],
                        lastNameFemale[randomNumber()],
                        email[randomNumber()],
                        groupName[randomNumber()]);
            } else {    //male
                out.printf("%s,%s,%s,%s\n",
                        nameMale[randomNumber()],
                        lastNameMale[randomNumber()],
                        email[randomNumber()],
                        groupName[randomNumber()]);
            }
        }
        out.close();
    }
}




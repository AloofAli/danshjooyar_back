package Menus;

import mainClasses.BeheshtiUniversityField;
import mainClasses.Teacher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class RegisterTeacher {
    public static void register() throws IOException, InterruptedException, JAXBException {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        System.out.println("Enter your name");
        teacher.setName(scanner.nextLine());
        System.out.println("Enter your password");
        teacher.setPASSWORD(scanner.nextLine());
        System.out.println("Enter your BirthDate (yyyy/MM/dd) ");
        String date = scanner.nextLine();
        teacher.setBirthDate(new Date(date));
        System.out.println("Enter your father name");
        teacher.setFatherName(scanner.nextLine());
        System.out.println("Enter your national ID");
        teacher.setNationalId(scanner.nextLine());
        System.out.println("Enter your Field" +
                "   1-COMPUTER_SCIENCE,\n" +
                "   2-LIFE_SCIENCE,\n" +
                "   3- SPORT_SCIENCE,\n" +
                "    4-AGRICULTURE_FORESTRY,\n" +
                "    5-BIOLOGICAL_SCIENCES,\n" +
                "    6-SOCIAL_SCIENCES,\n" +
                "    7-ENVIRONMENTAL_STUDIES,\n" +
                "    8-ENGINEERING_TECHNOLOGY,\n" +
                "    9-ARTS_HUMANITIES,\n" +
                "    10-ECONOMICS_BUSINESS,\n" +
                "    11-NATURAL_SCIENCES_MATH,\n" +
                "    12-PSYCHOLOGY,\n" +
                "    13-LAW,\n" +
                "    14-MEDICINE_HEALTHCARE;");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                teacher.setField(BeheshtiUniversityField.COMPUTER_SCIENCE);
                break;
            case "2":
                teacher.setField(BeheshtiUniversityField.LIFE_SCIENCE);
                break;
            case "3":
                teacher.setField(BeheshtiUniversityField.SPORT_SCIENCE);
                break;
            case "4":
                teacher.setField(BeheshtiUniversityField.AGRICULTURE_FORESTRY);
                break;
            case "5":
                teacher.setField(BeheshtiUniversityField.BIOLOGICAL_SCIENCES);
                break;
            case "6":
                teacher.setField(BeheshtiUniversityField.SOCIAL_SCIENCES);
                break;
            case "7":
                teacher.setField(BeheshtiUniversityField.ENVIRONMENTAL_STUDIES);
                break;
            case "8":
                teacher.setField(BeheshtiUniversityField.ARTS_HUMANITIES);
                break;
            case "9":
                teacher.setField(BeheshtiUniversityField.ECONOMICS_BUSINESS);
                break;
            case "10":
                teacher.setField(BeheshtiUniversityField.NATURAL_SCIENCES_MATH);
                break;
            case "11":
                teacher.setField(BeheshtiUniversityField.PSYCHOLOGY);
                break;
            case "12":
                teacher.setField(BeheshtiUniversityField.LAW);
                break;
            case "13":
                teacher.setField(BeheshtiUniversityField.MEDICINE_HEALTHCARE);
                break;
        }
        String name = teacher.getName();
        File file = new File("src/main/resources/Teachers" + "\\" + name + ".xml");
        JAXBContext context = JAXBContext.newInstance(Teacher.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(teacher, file);
        Thread.sleep(1000);
        System.out.println("\033[H\033[2J");
        System.out.flush();

    }
}
package Menus;

import mainClasses.Assignment;
import mainClasses.Course;
import mainClasses.Student;
import mainClasses.Teacher;

import javax.xml.bind.*;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TeacherMenu {
    static void teachermenu(Teacher teacher) throws IOException, InterruptedException, JAXBException {
        File outputFile = new File("src/main/resources/Teachers" + "\\" + teacher.getName() + ".xml");
        boolean finish = false;
        while (!finish) {

            System.out.println("1-Add course");
            System.out.println("2-Remove course");
            System.out.println("3-Add student");
            System.out.println("4-Remove student");
            System.out.println("5-Add Assignment");
            System.out.println("6-Remove Assignment");
            System.out.println("7-Grading");
            System.out.println("8-DeadLine Edit");
            System.out.println("9-Active Assignment");
            Scanner scanner = new Scanner(System.in);

            boolean validInput = false;
            while (!validInput) {
                String input = scanner.nextLine();
                switch (input) {
                    case "1": {

                        validInput = true;
                        System.out.println("Enter Course Name");
                        String name = scanner.nextLine();
                        System.out.println("Enter Course Credit");
                        String credit = scanner.nextLine();
                        Course course = new Course(name, Integer.parseInt(credit));
                        teacher.AddCourse(course);
                        JAXBContext context = JAXBContext.newInstance(Teacher.class);
                        Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marshaller.marshal(teacher, outputFile);
                        System.out.println("done!");
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "2": {

                        try {
                            validInput = true;
                            System.out.println("Enter Course Name");
                            String name2 = scanner.nextLine();
                            System.out.println("Enter  Credit");
                            String credit2 = scanner.nextLine();
                            teacher.RemoveCourse(new Course(name2, Integer.parseInt(credit2)));
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Course not Found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);

                        }
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "3": {

                        try {
                            validInput = true;
                            System.out.println("First Enter Course Then " + "Enter new students number" + " then their name and studentID (name-StudentID)");
                            String courseName = scanner.nextLine();
                            String number = scanner.nextLine();
                            int number2 = Integer.parseInt(number);
                            for (int i = 0; i < number2; i++) {
                                String[] detail = scanner.nextLine().split("-");
                                Course course = new Course(courseName);
                                teacher.AddStudent(course, new Student(detail[0], detail[1]));
                            }
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Course not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }


                    case "4": {

                        try {


                            validInput = true;
                            System.out.println("Enter Course Name");
                            String courseName2 = scanner.nextLine();
                            System.out.println("Enter Student name");
                            String name3 = scanner.nextLine();
                            System.out.println("Enter Student ID");
                            String ID = scanner.nextLine();
                            teacher.RemoveStudent(new Course(courseName2), new Student(name3, ID));
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Student or course not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "5": {

                        try {
                            validInput = true;
                            System.out.println("Enter Course Name");
                            String courseName = scanner.nextLine();
                            System.out.println("Enter Assignment Subject");
                            String subject = scanner.nextLine();
                            System.out.println("Enter Deadline (YYYY/MM/DD)");
                            String stringdate = scanner.nextLine();
                            System.out.println("Do you want to Active it ? Y/N");
                            String YN = scanner.nextLine();
                            boolean valid = false;
                            while (!valid) {
                                if (Objects.equals(YN, "Y")) {
                                    teacher.AddAssignment(new Course(courseName), new Assignment(subject, new Date(stringdate), true));
                                    valid = true;
                                } else if (Objects.equals(YN, "N")) {
                                    teacher.AddAssignment(new Course(courseName), new Assignment(subject, new Date(stringdate), false));
                                    valid = true;
                                } else {
                                    System.out.println("choose Y or N");
                                }
                            }
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("course not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "6": {

                        try {


                            validInput = true;
                            System.out.println("Enter your Course name");
                            String name5 = scanner.nextLine();
                            System.out.println("Enter your Assignment subject");
                            String name6 = scanner.nextLine();
                            teacher.RemoveAssignment(new Course(name5), new Assignment(name6));
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Assignment or course not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }
                        System.out.println("done!");
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "7": {

                        try {
                            validInput = true;
                            System.out.println("Enter course name");
                            String name = scanner.nextLine();
                            System.out.println("Enter Course Credit");
                            String credit = scanner.nextLine();
                            System.out.println("First Enter Name and ID then Score(name-ID-Score) ");
                            for (int i = 0; i < teacher.getCourses().get(teacher.getCourses().indexOf(new Course(name,Integer.parseInt(credit)))).getStudents().size(); i++) {
                                String[] detail = scanner.nextLine().split("-");
                               double score= Double.parseDouble(detail[2]);
                                teacher.Score(new Course(name,Integer.parseInt(credit)), new Student(detail[0], detail[1]), score);
                            }
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Course not found or Student or you grading more than students size");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }

                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "8": {


                        try {
                            validInput = true;
                            System.out.println("Enter your Course name");
                            String name5 = scanner.nextLine();
                            System.out.println("Enter your Assignment subject");
                            String name6 = scanner.nextLine();
                            System.out.println("Enter NewDeadline (YYYY/MM/DD)");
                            String stringdate = scanner.nextLine();
                            teacher.DeadLineTimeEdit(new Course(name5), new Assignment(name6), new Date(stringdate));
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Course or Assigment not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }
                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                finish = false;
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    case "9": {

                        try {
                            validInput = true;
                            System.out.println("Enter your Course name");
                            String name5 = scanner.nextLine();
                            System.out.println("Enter your Assignment subject");
                            String name6 = scanner.nextLine();
                            teacher.AssignmentActivator(new Course(name5), new Assignment(name6));
                            System.out.println("done!");
                            Thread.sleep(1000);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Course or Assigment not found");
                        } finally {
                            JAXBContext context = JAXBContext.newInstance(Teacher.class);
                            Marshaller marshaller = context.createMarshaller();
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                            marshaller.marshal(teacher, outputFile);
                        }

                        boolean V = false;
                        System.out.println("Finish? Y/N");
                        String finished = scanner.nextLine();

                        while (!V) {
                            if (Objects.equals(finished, "Y")) {
                                finish = true;
                                V = true;
                                System.out.println("done!");
                            } else if (Objects.equals(finished, "N")) {
                                V = true;
                            } else {
                                System.out.println("choose Y or N");
                            }
                        }
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }
                    default:
                        System.out.println("Choose valid Number");
                        System.out.println("done!");
                        Thread.sleep(1000);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                }
            }
        }
    }
}


package edu.frontrange.csc240.a6;

import edu.frontrange.util.ObjectCounter;
import java.util.ArrayList;

/**
 * Section class will keep track of the number of students in each section of 
 * every class. There can be many sections for the same Course. 
 * @author William Archbold, S02369823
 * @version 2018-10-09, CSC-240 Assignment 6 Course.java
 */
public class Section {
    
    //Create a reference variable counter to a new ObjectCounter object. The
    //ObjectCounter.java file increments the counter for every new object created
    private final ObjectCounter counter = new ObjectCounter(getClass());
    
    private final Course course;
    private final String sectionNumber;
    private final ArrayList<Student> students = new ArrayList<>();
    private final String newline = System.getProperty("line.separator");
    private static final int SECTION_LENGTH = 3;
    private static final int MAX_STUDENTS = 30;
    
    /**
     * Section constructor that takes 2 parameters. 
     * @param course
     * @param sectionNumber Check if section is null or not the right length
     */
    public Section(Course course, String sectionNumber) {
        this.course = course;
        
        //System.out.println("In Section, sectionNumber was " + sectionNumber);
        
        if (sectionNumber == null || sectionNumber.length() != SECTION_LENGTH) {
            sectionNumber = "";
            //System.out.println("In Section, sectionNumber is now " + sectionNumber);
            //throw null;
        }
        this.sectionNumber = sectionNumber;
    }
    
    /**
     * Method to add a student to the dynamic student array
     * @param thisStudent ensure that array is less than max size before adding
     *                    the student
     */
    public void addStudent(Student thisStudent) {
        if (thisStudent != null) {
            if (students.size() < MAX_STUDENTS) {
                students.add(thisStudent);
            }
        }
    }
    
    /**
     * Method to see all the students in a section object. Will iterate through
     * every student of the students array and add the result of toString for 
     * the particular student at that iteration to the answer. When the end of 
     * the students array is reached a newline won't be added due to if statement.  
     * @return answer String type concatenation of all student names 
     */
    public String getRoster() {
        String answer = "";
        int counter = 0;
        for (Student student : students) {
            counter += 1;
            answer += student.toString();
            //if (student.equals(students.size())) {
            if (counter == students.size()) { //this will trigger for last student
            break; //prevents a newline after last student
            }
            answer += newline;
        }
        return answer;
    }
    
    /**
     * alternative way of doing getRoster that doesn't iterate through student
     * type Student
    public String getRoster() {
        String answer = "";
        for (int i = 0; i < students.size(); i++) {
            answer += students.get(i);
            if (i != students.size()-1) {
            answer += newline;
            }
        }
        return answer;
    }
    */
    
    
    /**
     * The method will return the total number of students in the section. 
     * @return size of students array
     */
    public int getRosterCount() {
        return students.size();
    }
    
    /**
     * The method will return the section number of this section object
     * @return the section number string
     */
    public String getSectionNumber() {
        return this.sectionNumber;
    }
    
    /**
     * Method will get all the details of the section using format method. 
     * @return A concatenated string of all the details
     */
    public String getDetails() {
        return String.format("Section: %s-%s%sCourse: %s%sDates: %s to %s%sTimes: %s to %s%s"
                + "Enrollment: %d", this.toString(), this.sectionNumber, newline, course.getDetails(), newline,
                this.startDate.toString(), this.endDate.toString(), newline, 
                this.startTime.toString(), this.endTime.toString(), newline,
                getRosterCount());
    }
    
    //These will be used in two functions below
    private Time2 startTime;
    private Time2 endTime;
    private Date startDate;
    private Date endDate;
    
    /**
     * Method that will set the dates of a section. 
     * @param startDate 
     * @param endDate 
     */
    public void setDates(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Method will set the times that this section meets. 
     * @param startTime
     * @param endTime 
     */
    public void setTimes(Time2 startTime, Time2 endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
}

package utils.parse;

import entities.Course;
import solver.Factory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class CourseParse {

    CourseParse(){}
    public static Map<String, Course> parseCourse(NodeList courseList) {
        Map<String, Course> courses = new HashMap<>();
        for (int i = 0; i < courseList.getLength(); i++) {
            Node course = courseList.item(i);
            if (course.getNodeType() == Node.ELEMENT_NODE) {
                Element courseElement = (Element)course;
                Course courseParsed = new Course();
                courseParsed.setId(courseElement.getAttribute("id"));
                //courseParsed.setConfigurations(courseElement.getElementsByTagName("config"));
            }
        }
        return courses;
    }
}

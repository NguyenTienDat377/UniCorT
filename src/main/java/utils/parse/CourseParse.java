package utils.parse;

import entities.Configuration;
import entities.Course;
import entities.Class;
import entities.Subpart;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class   CourseParse {

    CourseParse(){}
    public static Map<String, Course> parseCourse(NodeList courseList) {
        Map<String, Course> courses = new HashMap<>();
        for (int i = 0; i < courseList.getLength(); i++) {
            Node course = courseList.item(i);
            if (course.getNodeType() == Node.ELEMENT_NODE) {
                Element courseElement = (Element)course;
                Course courseParsed = new Course();
                courseParsed.setId(courseElement.getAttribute("id"));
                courseParsed.setConfigurations(parseConfig(courseElement.getElementsByTagName("config")));
                courses.put(courseParsed.getId(), courseParsed);
            }
        }
        return courses;
    }
    public static Map<String, Configuration> parseConfig(NodeList configList) {
        Map<String, Configuration> configs = new HashMap<>();
        for (int i = 0; i < configList.getLength(); i++) {
            Node configNode = configList.item(i);
            if (configNode.getNodeType() == Node.ELEMENT_NODE) {
                Element configElement = (Element) configNode;
                Configuration config = new Configuration();
                config.setId(configElement.getAttribute("id"));
                config.setSubpart(parseSubpart(configElement.getElementsByTagName("subpart")));
                configs.put(config.getId(), config);
            }
        }
        return configs;
    }

    public static Map<String, Subpart> parseSubpart(NodeList subparList) {
        Map<String, Subpart> subparts = new HashMap<>();
        for (int i = 0; i < subparList.getLength(); i++) {
            Node subpartNode = subparList.item(i);
            if (subpartNode.getNodeType() == Node.ELEMENT_NODE) {
                Element subpartElement = (Element) subpartNode;
                Subpart subpart = new Subpart();
                subpart.setId(subpartElement.getAttribute("id"));
                subpart.setClasses(parseClass(subpartElement.getElementsByTagName("class")));
                subparts.put(subpart.getId(), subpart);
            }
        }
        return subparts;
    }

    public static Map<String, Class> parseClass(NodeList classList) {
        Map<String, Class> classes = new HashMap<>();
        for (int i = 0; i < classList.getLength(); i++) {
            Node classNode = classList.item(i);
            if (classNode.getNodeType() == Node.ELEMENT_NODE) {
                Element classElement = (Element) classNode;
                Class classParsed = new Class();
                classParsed.setId(classElement.getAttribute("id"));

                classes.put(String.valueOf(classParsed.getId()), classParsed);
            }
        }
        return classes;
    }
}

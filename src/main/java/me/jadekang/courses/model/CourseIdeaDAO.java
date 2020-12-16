package me.jadekang.courses.model;
import java.util.List;

public interface CourseIdeaDAO {
    // I need a way to add a class
    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug);
}

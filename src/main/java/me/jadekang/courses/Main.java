package me.jadekang.courses;
import me.jadekang.courses.model.CourseIdeaDAO;
import me.jadekang.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


public class Main {
    public static void main(String[] args) {

        // Make my model object
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        port(8000);
        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);
            model.put("username", username);
            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

package me.jadekang.courses;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


public class Main {
    public static void main(String[] args) {
        port(8000);
        get("/", (req, res) -> {
            return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req, res) -> {
            return new ModelAndView(null, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

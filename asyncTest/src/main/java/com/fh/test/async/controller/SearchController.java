package com.fh.test.async.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@RequestMapping("/async/")
public class SearchController {

    @RequestMapping("/search.htm")
    public String doSearch(@RequestParam(value = "latency", defaultValue = "2000") long latency,
                           @RequestParam(value = "blowup", defaultValue = "false") boolean blowUp,
                           Model model) throws Exception {

        String searchResult = getSearchResult(latency, blowUp);

        model.addAttribute("result", searchResult);
        return "searchResult";
    }

    @RequestMapping("/search.ajax")
    public void doSearchAjax(@RequestParam(value = "latency", defaultValue = "2000") long latency,
                             @RequestParam(value = "blowup", defaultValue = "false") boolean blowUp,
                             HttpServletResponse response) throws Exception {

        String searchResult = getSearchResult(latency, blowUp);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(searchResult);
            writer.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getSearchResult(long latency, boolean blowUp) throws Exception {

        if (blowUp) {
            throw new RuntimeException("Bad error happened in controller");
        }

        Thread.sleep(latency);

        StringBuilder builder = new StringBuilder("Some search/whatever results being returned");
        Date now = new Date();
        builder.append(" @").append(now);

        return builder.toString();
    }



    @RequestMapping("/user.do")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hi, u guy.");
    }
}
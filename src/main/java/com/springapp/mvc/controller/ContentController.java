package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Content;
import com.springapp.mvc.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by user on 7/21/2015.
 */
@Controller
public class ContentController {
    @Autowired
    ContentService contentService;

    @RequestMapping(value = "addcontent", method = RequestMethod.POST)
    public String printWelcome(ModelMap model, @RequestParam("title") String title, @RequestParam("text") String text) {

        Content content = new Content();
        content.setTitle(title);
        content.setContent(text);
        contentService.updateRow(content);
        model.addAttribute("message", "Content added!");
        return "home";
    }

    @RequestMapping("contentlist")
    public ModelAndView getList() {
        List contentList = contentService.getList();
        return new ModelAndView("contentlist", "contentList", contentList);
    }

    @RequestMapping("/remove/{id}")
    public String removeContent(@PathVariable("id") int id) {
        this.contentService.deleteRow(id);
        return "redirect:/contentlist";
    }

    @RequestMapping("/edit/{id}")
    public String editContent(@PathVariable("id") int id, Model model) {
        model.addAttribute("content", this.contentService.getRowById(id));
        model.addAttribute("contentList", this.contentService.getList());
        return "contentlist";
    }

    /**
     *  Method which test jstl form
     */

    @RequestMapping(value = "jstlAdd", method = RequestMethod.POST)
    public String addJstlContent(@ModelAttribute("SpringWeb") Content content)
    {
        contentService.updateRow(content);

        return "home";
    }
}

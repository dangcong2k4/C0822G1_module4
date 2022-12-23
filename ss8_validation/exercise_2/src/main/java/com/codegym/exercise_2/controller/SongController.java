package com.codegym.exercise_2.controller;

import com.codegym.exercise_2.dto.SongDto;
import com.codegym.exercise_2.model.Song;
import com.codegym.exercise_2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate( Model model){
        Song song = new Song();
        model.addAttribute("songDto",song);
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        songService.save(song);
        return "redirect:";
    }


    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("songDto",songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        songService.update(song);
        return "redirect:";
    }
}

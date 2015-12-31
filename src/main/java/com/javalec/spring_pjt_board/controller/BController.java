package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplyCommand;
import com.javalec.spring_pjt_board.command.BReplyViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;

@Controller
public class BController {

	BCommand command;

	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list()시작");

		command = new BListCommand();
		command.execute(model);
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model){
		System.out.println("write_view() 시작 작성하는화면");
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){ // write view의 폼에서 받은 데이터를 받기 위해 httpservletrequset
		System.out.println("write() 시작");

		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view() 실행");

		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);

		return "content_view";
	}

	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify 실행중");
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model); 
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){

		System.out.println("reply_view() 실행중");
		model.addAttribute("request", request);

		command = new BReplyViewCommand();
		command.execute(model);

		return "reply_view";
	}


	@RequestMapping("reply")
	public String reply(HttpServletRequest request, Model model ){

		System.out.println("reply 실행");

		model.addAttribute("request", request);

		command = new BReplyCommand();
		command.execute(model);

		return "redirect:list";

	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){

		System.out.println("delete() 실행");

		model.addAttribute("request", request);

		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}


}

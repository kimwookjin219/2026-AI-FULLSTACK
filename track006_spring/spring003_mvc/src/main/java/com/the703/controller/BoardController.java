package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	// 1. 전체 리스트
	@RequestMapping("/board/list.do")
	public String list(Model model) { 
		model.addAttribute("list",service.selectAll()); 
		return "board/list"; }
	// /view (폴더)  /board(폴더)/list(파일명)   + .jsp 
	
	// 2. 글쓰기 폼경로
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String write() { return "board/write"; }
	
	// 2. 글쓰기 기능
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String write_post(BoardDto dto, RedirectAttributes rttr) { 
		String result = "글쓰기 실패";
		
		if(service.insert(dto)>0) { result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result",result); //Flash - 한번만 동작
		return "redirect:/board/list.do"; // response.sendRedirect + alert (X)
	}
	
	// 3. 글 상세보기
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		
		model.addAttribute("dto",service.detail(bno));
		
		return "board/detail";
		}
	
	// 4. 글 수정폼 경로
	@RequestMapping(value="/board/edit.do", method = RequestMethod.GET)
	public String edit(int bno,Model model) { 
		
		model.addAttribute("dto", service.editView(bno) );
		
		return "board/edit"; 
		}
	
	// 5. 글 수정 기능
	@RequestMapping(value="/board/edit.do",method = RequestMethod.POST)
	public String edit_post(BoardDto dto,RedirectAttributes rttr) { 
		String result = "수정 실패";
		
		if(service.edit(dto)>0) { result="수정 성공"; }
		rttr.addFlashAttribute("result",result);
		
		return "redirect:/board/detail.do?bno="+dto.getBno();
	}
	// 6. 글 삭제폼
	@RequestMapping(value="/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno) { 
		return "board/delete"; 
		}
	
	// 7. 글삭제 기능
	@RequestMapping(value="/board/delete.do", method=RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) { 
		String result = "삭제 실패";
		
		if(service.delete(dto)>0) { result="삭제 성공"; }
		rttr.addFlashAttribute("result",result);
		
		return "redirect:/board/list.do"; 
		}
	
}

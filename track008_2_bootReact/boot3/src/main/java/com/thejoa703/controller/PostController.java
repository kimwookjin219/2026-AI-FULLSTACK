package com.thejoa703.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.service.AuthUserJwtService;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post Api" , description = "게시글 관련 API") // swagger
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	private final AuthUserJwtService authUserJwtService; // ###
	
	// 게시글 작성
	@Operation(summary = "게시글 작성" , description = "특정유저 ID와 내용을 받아 게시글을 등록합니다.")
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public ResponseEntity<PostResponseDto> createPost(
			Authentication authentication,
			@Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto dto ,  // multipart/form-data
			@Parameter(description = "업로드할 이미지 파일 리스트") // swagger
			@RequestPart(name = "files", required = false) List<MultipartFile> files
			){
		return ResponseEntity.ok(postService.createPost(userId, dto, files)); // 응답 성공 201
	}
	
	// 전체 게시글 조회
//	@Operation(summary = "전체 게시글 조회" , description = "전체 게시글을 조회합니다.")
//	@GetMapping
//	public ResponseEntity<List<PostResponseDto>> getAllPosts(){
//		List<Post> posts = postService.getAllPosts();		
//		List<PostResponseDto> lists = posts.stream()
//										   .map(PostResponseDto::from)     // new PostResponseDto(post)
//										   .collect(Collectors.toList()); // list로 변경
//		
//		return ResponseEntity.ok(lists); // 200
//	}
	@Operation(summary = "전체 게시글 조회" , description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getPosts(){
		return ResponseEntity.ok(postService.getAllPosts());
	}
	
	// 게시글 단건 조회
	@Operation(summary = "게시글 단건조회" , description = "사용자 ID로 특정게시글을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id){
		Post post = postService.getPostById(id);		
		
		return ResponseEntity.ok(PostResponseDto.from(post)); // 200
	}
	
	// Patch    /api/posts/{postId}
	@Operation(summary = "게시글 수정" , description = "게시글 수정시") // 수정 put(전체데이터 수정) , patch(데이터 일부만 수정)
	@PatchMapping(value= "/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)  //  Put (리소스의 전체 교체) / Patch (부분 수정)
	public ResponseEntity<PostResponseDto> getUpdatePost(
			Authentication authentication,
			//@Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
			@Parameter(description = "수정할 게시글 ID") @PathVariable(name="postId") Long postId,
			@ModelAttribute PostRequestDto dto ,  // 게시글 내용 + 댓글 받아오기
			@Parameter(description = "수정시 업로드할 이미지 파일 리스트") // swagger
			@RequestPart(name = "files", required = false) List<MultipartFile> files
			){		
		Long userId = authUserJwtService.getCurrentUserId(authentication);
		return ResponseEntity.ok(postService.updatePost(userId, postId, dto, files)); // 200
	}
	
	// 게시글 삭제
	@Operation(summary = "게시글 삭제" , description = "게시글 ID로 특정게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(
			Authentication authentication,
			@PathVariable("id") Long id
			){
		Long userId = authUserJwtService.getCurrentUserId(authentication);
		postService.deletePost(userId ,id);
		return ResponseEntity.ok(id); // 200
	}
		
}
//  요청 : PostRequestDto, 응답 : PostResponseDto
/*
- GET      /api/posts/{id}    게시글 단건 조회 ※ getPostById  
- PUT      /api/posts/{id}    게시글 수정 ※ updatePost
- DELETE   /api/posts/{id}    게시글 삭제 ※ deletePost
- GET      /api/posts         전체 게시글 조회 ※ getAllPosts or getPostPaged
- POST     /api/posts         게시글 작성  ※기능: postService.createPost   
*/
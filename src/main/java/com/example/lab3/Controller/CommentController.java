package com.example.lab3.Controller;

import com.example.lab3.Dto.*;
import com.example.lab3.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping(value = "/{id}")
    public CommentDto getComment(@PathVariable String id) {
        return commentService.getCommentDtoById(id);
    }

    @PostMapping
    public CommentDto createComment(@RequestBody CreateUpdateCommentDto createUpdateCommentDto) {
        return commentService.createComment(createUpdateCommentDto);
    }
}

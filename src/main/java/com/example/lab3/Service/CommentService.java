package com.example.lab3.Service;

import com.example.lab3.Converter.TaskDtoConverter;
import com.example.lab3.Dto.CommentDto;
import com.example.lab3.Dto.CreateUpdateCommentDto;
import com.example.lab3.Dto.UserDto;
import com.example.lab3.Entity.CommentEntity;
import com.example.lab3.Exception.TaskNotFoundException;
import com.example.lab3.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;

    @Transactional
    public CommentDto createComment(CreateUpdateCommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(UUID.randomUUID().toString());
        commentEntity.setCreateDate(commentDto.getCreateDate());
        commentEntity.setEditDate(commentDto.getEditDate());
        commentEntity.setText(commentDto.getText());
        var savedEntity = commentRepository.save(commentEntity);
        return new CommentDto(
                savedEntity.getId(),
                savedEntity.getCreateDate(),
                savedEntity.getEditDate(),
                savedEntity.getUser().getFullName(),
                TaskDtoConverter.convertTasksToDto(savedEntity.getTasks()),
                savedEntity.getText()
        );
    }

    @Transactional(readOnly = true)
    public CommentEntity getCommentEntityById(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Комментарий с id " + id + " не найден"));

    }

    public CommentDto getCommentDtoById(String id) {
        CommentEntity commentEntity = getCommentEntityById(id);
        return new CommentDto(
                commentEntity.getId(),
                commentEntity.getCreateDate(),
                commentEntity.getEditDate(),
                userService.getUserDtoById(commentEntity.getId()),
                TaskDtoConverter.convertTasksToDto(commentEntity.getTasks()),
                commentEntity.getText()
        );
    }
}

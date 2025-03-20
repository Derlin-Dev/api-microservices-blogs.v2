package com.microservices.comments_services.controller;

import com.microservices.comments_services.data.dto.CommentRequest;
import com.microservices.comments_services.data.model.CommentEntity;
import com.microservices.comments_services.data.repository.CommentRepositori;
import com.microservices.comments_services.exception.InvalidOperationException;
import com.microservices.comments_services.exception.ResourceNotFoundException;
import com.microservices.comments_services.service.CommentService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RefreshScope
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Obtener todos los comentarios de un post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByPostId(@PathVariable Long postId) throws ResourceNotFoundException {
        List<CommentEntity> comments = commentService.getAllCommentPostId(postId);
        return ResponseEntity.ok(comments);
    }

    // Obtener todos los comentarios de un usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
        List<CommentEntity> comments = commentService.getAllCommentsByUserId(userId);
        return ResponseEntity.ok(comments);
    }

    // Crear un nuevo comentario
    @PostMapping("/user/new")
    public ResponseEntity<?> createComment(@RequestBody CommentRequest commentRequest) throws InvalidOperationException {
        String newComment = commentService.newComment(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComment);
    }

    // Actualizar un comentario
    @PutMapping("/user/put/{id}")
    public ResponseEntity<CommentEntity> updateComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest) throws InvalidOperationException {
        CommentEntity updatedComment = commentService.updateComment(id, commentRequest);
        return ResponseEntity.ok(updatedComment);
    }

    // Eliminar un comentario
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) throws ResourceNotFoundException {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}

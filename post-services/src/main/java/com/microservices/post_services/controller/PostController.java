package com.microservices.post_services.controller;

import com.microservices.post_services.data.dto.PostResponse;
import com.microservices.post_services.data.dto.PostRequest;
import com.microservices.post_services.data.model.PostEntity;
import com.microservices.post_services.exception.InvalidOperationException;
import com.microservices.post_services.exception.ResourceNotFoundException;
import com.microservices.post_services.service.PostService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RefreshScope
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPost() throws ResourceNotFoundException {
        List<PostEntity> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByIdPost(@PathVariable Long id) throws ResourceNotFoundException {
        PostResponse postResponse = postService.getIdPost(id);
        return ResponseEntity.ok(postResponse);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newPost(@RequestBody PostRequest postRequest) throws InvalidOperationException {
        return ResponseEntity.ok(postService.newPost(postRequest));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) throws InvalidOperationException {
        return ResponseEntity.ok(postService.updatePost(id, postRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(postService.deletePostById(id));
    }

    //--------------------------------------------------------------------------------------------------------------------

    @PutMapping("/{postId}/update-comment")
    public ResponseEntity<?> actualizarCantidadComentarios(@PathVariable Long postId, @RequestParam("cantidad") int cantidad){

        postService.actualizarCantidadComentarios(postId, cantidad);
        return ResponseEntity.ok("Post actualizado");

    }

}

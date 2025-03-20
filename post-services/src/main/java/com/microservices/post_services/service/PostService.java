package com.microservices.post_services.service;

import com.microservices.post_services.data.dto.PostResponse;
import com.microservices.post_services.data.dto.PostRequest;
import com.microservices.post_services.data.model.PostEntity;
import com.microservices.post_services.data.repository.PostRepository;
import com.microservices.post_services.exception.InvalidOperationException;
import com.microservices.post_services.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Obtener todos los post.
    public List<PostEntity> getAllPost() throws ResourceNotFoundException {
        List<PostEntity> list = postRepository.findAll();
        if (list.isEmpty()) throw new ResourceNotFoundException("Error al octener los Post...");
        return list;
    }

    //obtener un post por su id.
    public PostResponse getIdPost(Long id) throws ResourceNotFoundException {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Post no encontrado con ID: " + id
                ));
        return setPostEntity(post);
    }
    
    public String newPost(PostRequest post) throws InvalidOperationException {
        try {
            post.setFechaDeCreacion(LocalDateTime.now());
            postRepository.save(getPostResquet(post));
            return "Post Creado correctamente....!";
        } catch (Exception e){
            throw new InvalidOperationException("Error al crear nuevo Post...");
        }
    }

    public String updatePost(Long id, PostRequest post) throws InvalidOperationException {
        Optional<PostEntity> postOp = postRepository.findById(id);
        if (postOp.isPresent()){
            PostEntity postEntity = postOp.get();

            postEntity.setTitulo(post.getTitulo());
            postEntity.setContenido(post.getContenido());
            postEntity.setFechaDeModificacion(LocalDateTime.now());
            postRepository.save(postEntity);

            return "Post actualizado correctamente";

        }else {
            throw new InvalidOperationException("Error al actualizar el Post");
        }
    }

    public String deletePostById(Long id) throws ResourceNotFoundException{
        Optional<PostEntity> post = postRepository.findById(id);
        if (post.isEmpty())throw new ResourceNotFoundException(
                "Post no encontrado : id post" + id
        );
        postRepository.deleteById(id);
        return "Post eliminado correctamente..!";
    }

    public void actualizarCantidadComentarios(Long id, int cantidad){
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrado en la base de datos...!"));

        post.setNumeroDeCometarios(cantidad);
        postRepository.save(post);
    }

    public PostEntity getPostResquet(PostRequest postRequest){
        return new PostEntity(
                postRequest.getTitulo(),
                postRequest.getContenido(),
                postRequest.getTag(),
                postRequest.getFechaDeCreacion(),
                postRequest.getFechaDeModificacion(),
                postRequest.getNumeroDeCometarios()
        );
    }

    public PostResponse setPostEntity(PostEntity post){
        return new PostResponse(
               post.getId(),
               post.getTitulo(),
                post.getContenido(),
                post.getTag(),
                post.getFechaDeCreacion(),
                post.getFechaDeModificacion(),
                post.getNumeroDeCometarios()
        );
    }
}

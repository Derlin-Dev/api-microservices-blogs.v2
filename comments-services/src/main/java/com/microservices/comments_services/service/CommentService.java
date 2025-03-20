package com.microservices.comments_services.service;

import com.microservices.comments_services.client.PostServiceClient;
import com.microservices.comments_services.data.dto.CommentRequest;
import com.microservices.comments_services.data.model.CommentEntity;
import com.microservices.comments_services.data.repository.CommentRepositori;
import com.microservices.comments_services.exception.InvalidOperationException;
import com.microservices.comments_services.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepositori commentRepositori;
    private final PostServiceClient postServiceClient;

    public CommentService(CommentRepositori commentRepositori, PostServiceClient postServiceClient) {
        this.commentRepositori = commentRepositori;
        this.postServiceClient = postServiceClient;
    }

    public List<CommentEntity> getAllCommentPostId(Long postId)throws ResourceNotFoundException {
        List<CommentEntity> comments = commentRepositori.findByPostId(postId);
        if (comments.isEmpty()){
            throw new ResourceNotFoundException("Error al traer los comentarios");
        }
        return comments;
    }

    public List<CommentEntity> getAllCommentsByUserId(Long userId)throws ResourceNotFoundException {
        List<CommentEntity> comments = commentRepositori.findByUserId(userId);

        if (comments.isEmpty()){
            throw new ResourceNotFoundException("Error al traer los comentarios");
        }
        return comments;
    }

    public String newComment(CommentRequest commentRequest) throws InvalidOperationException {
       try{
           commentRequest.setFechaDeCreacion(LocalDateTime.now());
           CommentEntity commentEntity = getCommentRequest(commentRequest);
           commentRepositori.save(commentEntity);

           int cantidad = obtenerCantidadDeComentarios(commentEntity.getPostId()) + 1;

           postServiceClient.actualizarCantidadComentarios(commentRequest.getPostId(), cantidad);

           return "Commentario Creado correctamente...!";
       }catch (Exception e){
           throw new InvalidOperationException("Error al registrar el comentario");
       }
    }

    public CommentEntity updateComment(Long id, CommentRequest commentRequest) throws InvalidOperationException {
        CommentEntity comment = commentRepositori.findById(id)
                .orElseThrow(() -> new InvalidOperationException("Comentario no encontrado"));

        comment.setComment(commentRequest.getComment());
        comment.setFechaDeModficacion(LocalDateTime.now());

        return commentRepositori.save(comment);
    }

    public void deleteComment(Long id) throws ResourceNotFoundException {
       CommentEntity comment = commentRepositori.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
       commentRepositori.deleteById(id);
    }

    public int obtenerCantidadDeComentarios(Long postId){
        return commentRepositori.countByPostId(postId);
    }

    public CommentEntity getCommentRequest(CommentRequest commet){

        return new CommentEntity(
                commet.getUserId(),
                commet.getPostId(),
                commet.getComment(),
                commet.getFechaDeCreacion(),
                commet.getFechaDeModficacion()
        );
    }
}

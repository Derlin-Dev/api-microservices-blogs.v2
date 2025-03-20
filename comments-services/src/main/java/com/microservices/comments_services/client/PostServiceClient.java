package com.microservices.comments_services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "post-services")
public interface PostServiceClient {

    @PutMapping("/post/{postId}/update-comment")
    void actualizarCantidadComentarios(@PathVariable Long postId, @RequestParam("cantidad") int cantidad);

}

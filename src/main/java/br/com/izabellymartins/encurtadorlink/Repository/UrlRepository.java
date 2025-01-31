package br.com.izabellymartins.encurtadorlink.Repository;

import br.com.izabellymartins.encurtadorlink.Models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlModel, Long> {
    Optional<UrlModel> findByUrlencurtada(String urlencurtada);

    Optional<UrlModel> findByOriginalurl(String originalUrl);
}


package br.com.izabellymartins.encurtadorlink.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UrlModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String originalurl;

    @Column(unique = true, nullable = false)
    private String urlencurtada;

    private LocalDateTime dataDeExpiracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalurl() {
        return originalurl;
    }

    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }

    public String getUrlencurtada() {
        return urlencurtada;
    }

    public void setUrlencurtada(String urlencurtada) {
        this.urlencurtada = urlencurtada;
    }

    public LocalDateTime getDataDeExpiracao() {
        return dataDeExpiracao;
    }

    public void setDataDeExpiracao(LocalDateTime dataDeExpiracao) {
        this.dataDeExpiracao = dataDeExpiracao;
    }
}

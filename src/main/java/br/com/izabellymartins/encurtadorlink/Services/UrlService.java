package br.com.izabellymartins.encurtadorlink.Services;

import br.com.izabellymartins.encurtadorlink.Models.UrlModel;
import br.com.izabellymartins.encurtadorlink.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;


    // Definindo tamanho e caracters para a URL
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TAMANHO_URL = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    public String encurtarUrl(String originalUrl) {

        // Verifica se a URL já foi encurtada anteriormente
        Optional<UrlModel> urlExistente = urlRepository.findByOriginalurl(originalUrl);
        if (urlExistente.isPresent()) {
            return urlExistente.get().getUrlencurtada();
        }

        String urlEncurtada;
        do {
            urlEncurtada = gerarUrlCurta();
        } while (urlRepository.findByUrlencurtada(urlEncurtada).isPresent());

        // Cria um novo objeto UrlModel para armazenar a URL original
        UrlModel url = new UrlModel();
        url.setOriginalurl(originalUrl);
        url.setUrlencurtada(urlEncurtada);
        url.setDataDeExpiracao(LocalDateTime.now().plusDays(30));

        urlRepository.save(url);
        return urlEncurtada;
    }
    // Aqui usamos esse método para buscar a URL original associada a uma URL encurtada
    public Optional<UrlModel> obterUrlOriginal(String urlEncurtada) {
        // Filtrando  URLs que ainda não expiraram no banco!
        return urlRepository.findByUrlencurtada(urlEncurtada)
                .filter(url -> url.getDataDeExpiracao().isAfter(LocalDateTime.now()));
    }

    // Retorna a URL encurtada gerada!!
    private String gerarUrlCurta() {
        StringBuilder urlEncurtada = new StringBuilder();
        for (int i = 0; i < TAMANHO_URL; i++) {
            urlEncurtada.append(CARACTERES.charAt(RANDOM.nextInt(CARACTERES.length())));
        }
        return urlEncurtada.toString();
    }
}

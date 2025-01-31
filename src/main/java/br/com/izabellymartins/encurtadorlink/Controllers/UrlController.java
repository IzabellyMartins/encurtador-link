package br.com.izabellymartins.encurtadorlink.Controllers;

import br.com.izabellymartins.encurtadorlink.Models.UrlModel;
import br.com.izabellymartins.encurtadorlink.Services.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "*")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/encurtar")
    public ResponseEntity<Map<String, String>> encurtarUrl(@RequestBody Map<String, String> request) {

        /* Obtendo a URL original enviada pelo usuário na requisição
           E verificando se ela é nula ou vazia.
         */
        String originalUrl = request.get("url");
        if (originalUrl == null || originalUrl.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "A URL original é obrigatória."));
        }
        // Gerando a Url Encurtada
        String urlEncurtada = urlService.encurtarUrl(originalUrl);
        return ResponseEntity.ok(Map.of("urlEncurtada", urlEncurtada)); // Retorna apenas o código
    }

    @GetMapping("/{urlEncurtada}")
    public ResponseEntity<?> redirecionar(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {

        // Aqui buscando se a URL já está no banco de dados ou se está expirada
        Optional<UrlModel> urlOptional = urlService.obterUrlOriginal(urlEncurtada);

        if (urlOptional.isPresent()) {
            response.sendRedirect(urlOptional.get().getOriginalurl());
            return ResponseEntity.status(HttpServletResponse.SC_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", "URL encurtada não encontrada ou expirada."));
    }
}
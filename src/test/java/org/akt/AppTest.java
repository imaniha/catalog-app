package org.akt;

import org.akt.domain.Book;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class AppTest {

  @Autowired
  private WebTestClient webTestClient;
  @Test
  void whenPostRequestThenBookCreated() {
    var expectedBook =  Book.of("1231241231", "Title", "Author", 9.90);

    webTestClient
            .post()
            .uri("/books")
            .bodyValue(expectedBook)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(Book.class).value(actualBook -> {
              assertThat(actualBook).isNotNull();
              assertThat(actualBook.isbn())
                      .isEqualTo(expectedBook.isbn());
            });
  }
}

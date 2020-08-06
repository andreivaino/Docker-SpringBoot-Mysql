package ee.docker.app.rest;

import ee.docker.app.dto.TestDTO;
import ee.docker.app.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/rest-api")
public class TestController {

  private final TestService testService;

  @GetMapping("/test/{id}")
  public ResponseEntity<?> getJson(@PathVariable Long id) {
    TestDTO testDto = testService.getDtoById(id);
    return new ResponseEntity<>(
        TestDTO.builder()
            .id(testDto.getId())
            .title(testDto.getTitle())
            .build(),
        HttpStatus.OK);
  }

}

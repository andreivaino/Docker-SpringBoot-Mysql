package ee.docker.app.service;

import ee.docker.app.dto.TestDTO;
import ee.docker.app.entity.Test;
import ee.docker.app.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TestService {

  private final TestRepository testRepository;

  public TestDTO getDtoById(Long id) {
    Test test = testRepository.findById(id).orElse(new Test(id, "TEST WITH NOT EXISTED ID"));
    return TestDTO.builder()
        .id(test.getId())
        .title(test.getValue())
        .build();
  }

}

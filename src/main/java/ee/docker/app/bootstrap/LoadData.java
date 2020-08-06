package ee.docker.app.bootstrap;

import ee.docker.app.entity.Test;
import ee.docker.app.repository.TestRepository;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoadData {

  private final TestRepository testRepository;

  @PostConstruct
  private void load() {
    Test test = new Test();
    test.setValue("Loaded test value");
    testRepository.saveAndFlush(test);
  }

}

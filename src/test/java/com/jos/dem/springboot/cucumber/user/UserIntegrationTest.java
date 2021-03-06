/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.springboot.cucumber.user;

import com.jos.dem.springboot.cucumber.CucumberApplication;
import com.jos.dem.springboot.cucumber.model.Response;
import com.jos.dem.springboot.cucumber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = CucumberApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  @Qualifier("userWebclient")
  private WebClient webClient;

 /* User shouldGetUser(String userId) throws Exception {
    return webClient.get().uri(userId).retrieve().toEntity(User.class);

  }*/

  Mono<User> getUser(String useID) throws Exception {
    return webClient.get()
            .uri(useID)
            .retrieve()
            .bodyToMono(User.class);
  }

}

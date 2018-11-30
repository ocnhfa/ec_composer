/*
 * Copyright 2018 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.metacontext.ec.prototype.composer2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import tech.metacontext.ec.prototype.composer2.styles.Style1;
import tech.metacontext.ec.prototype.composer2.styles.Style2;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

  public static void main(String[] args) {

    int size = 5;
    Composer composer = new Composer(size);

    composer.setStyles(Arrays.asList(
            new Style1(),
            new Style2()
    ));
    List<List<Composition>> archive
            = IntStream.rangeClosed(1, 5)
                    .peek(i -> System.out.println("Generation " + (i)))
                    .mapToObj(i -> composer.compose())
                    .peek(list -> list.stream().forEach(Composition::render))
                    .collect(Collectors.toList());

    IntStream.range(0, 5)
            .peek(i -> System.out.println("Generation " + (i + 1)))
            .mapToObj(archive::get)
            .forEach(list -> list.stream().forEach(Composition::render));
  }

}
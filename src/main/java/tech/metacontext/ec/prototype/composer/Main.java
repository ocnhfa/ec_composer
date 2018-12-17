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
package tech.metacontext.ec.prototype.composer;

import java.util.stream.IntStream;
import tech.metacontext.ec.prototype.composer.enums.ComposerAim;
import tech.metacontext.ec.prototype.composer.styles.GoldenSectionClimax;
import tech.metacontext.ec.prototype.composer.styles.UnaccompaniedCello;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

    // 決定作品數量及演進世代
    static int populationSize = 15;
    static int generation = 10;

    public static void main(String[] args) {

        System.out.println(header("Creating composer..."));
        System.out.println("Population Size = " + populationSize);
        System.out.println("Generation = " + generation);
        Composer composer = new Composer(populationSize, ComposerAim.Phrase,
                new UnaccompaniedCello(),
                new GoldenSectionClimax()
        );

        System.out.println(header("Evolution"));
        System.out.print("Generation...");
        do {
            System.out.print(composer.getGenCount() + " ");
            composer.compose();
            composer.evolve();
        } while (composer.getGenCount() < generation);

        System.out.println(header("Dumping Archive"));
        IntStream.range(0, generation)
                .peek(i -> System.out.println("----------Generation " + i))
                .mapToObj(composer.getArchive()::get)
                .forEach(list -> list.stream()
                /*...*/.forEach(c -> c.render(composer.generateSeed())));
        composer.render();
        System.out.println(header("Dumping Conservatory"));
        composer.getConservetory().forEach(System.out::println);
    }

    static String header(String text) {
        return "\n---------- " + text + " ----------";
    }

}

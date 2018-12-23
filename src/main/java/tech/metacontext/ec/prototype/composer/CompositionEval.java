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

import tech.metacontext.ec.prototype.composer.rules.Rule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import tech.metacontext.ec.prototype.composer.styles.Style;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class CompositionEval {

    private final Map<Style, Double> scores;
//    private List<Rule> rules;

    public CompositionEval(Map<? extends Style, Double> scores) {

        this.scores = new HashMap<>(scores);
//        this.rules = new ArrayList<>();
    }

    public CompositionEval(Collection<? extends Style> styles) {

        this(styles.stream().collect(Collectors.toMap(s -> s, s -> 0.0)));
    }

//    public void addRule(Rule rule) {
//
//        this.rules.add(rule);
//    }
    public Set<? extends Style> getStyles() {

        return this.getScores().keySet();
    }

    /*
     * Default setters and getters
     */
    public Map<Style, Double> getScores() {
        return scores;
    }
//    public List<Rule> getRules() {
//        return rules;
//    }
//
//    public void setRules(List<Rule> rules) {
//        this.rules = rules;
//    }

}

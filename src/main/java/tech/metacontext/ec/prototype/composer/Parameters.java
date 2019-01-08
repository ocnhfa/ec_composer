/*
 * Copyright 2019 Jonathan Chang.
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

/**
 *
 * @author Jonathan Chang
 */
public enum Parameters {
    /**
     * Chance to reset seed when mutation happens.
     */
    CHANCE_RESEEDING(0.5),
    /**
     * Score threshold percentage for selection.
     */
    SELECTION_THRESHOLD(0.9),
    /**
     * Score for a mature composition to reach to be conserved.
     */
    SCORE_CONSERVE_IF_COMPLETED(0.93),
    /**
     * Chance for a mature composition to be elongated.
     */
    CHANCE_ELONGATION_IF_COMPLETED(0.1),
    /**
     * Chance for a mature composition to do crossover than mutation.
     */
    CHANCE_CROSSOVER_IF_COMPLETED(0.6),
    /**
     * Chance to produce a Total Connecting State
     */
    CHANCE_TOTAL_CONNECTING_STATE(0.2),
    /**
     * Chance to preserve when producing a Repetition Transform Type
     */
    CHANCE_REPETITION(0.2),
    /**
     * Chance to preserve when producing a MoveForward Transform Type
     */
    CHANCE_MOVEFORWARD(0.8),
    /**
     * Chance to preserve when producing a MoveBackward Transform Type
     */
    CHANCE_MOVEBACKWARD(0.8),
    /**
     * Chance to preserve when producing a Retrograde Transform Type
     */
    CHANCE_RETROGRADE(0.6),
    /**
     * Chance to preserve when producing a Disconnected Transform Type
     */
    CHANCE_DISCONNECTED(1.0),
    DEFAULT_DIVISION(2),
    DEFAULT_MIN_DIVISION(1),
    DEFAULT_MAX_DIVISION(4);

    public final Number value;

    Parameters(double value) {
        this.value = value;
    }

    public double getDouble() {

        return value.doubleValue();
    }

    public int getInt() {

        return value.intValue();
    }
}

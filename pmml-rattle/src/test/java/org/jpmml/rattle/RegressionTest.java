/*
 * Copyright (c) 2013 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.rattle;

import java.util.Set;

import com.google.common.collect.Sets;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Batch;
import org.jpmml.evaluator.BatchUtil;
import org.jpmml.evaluator.NodeScore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegressionTest {

	@Test
	public void evaluateDecisionTreeAuto() throws Exception {
		Batch batch = new RattleBatch("DecisionTree", "Auto");

		NodeScore targetValue = (NodeScore)BatchUtil.evaluateDefault(batch);

		assertEquals("14", targetValue.getEntityId());

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateGeneralRegressionAuto() throws Exception {
		Batch batch = new RattleBatch("GeneralRegression", "Auto");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateKernlabSVMAuto() throws Exception {
		Batch batch = new RattleBatch("KernlabSVM", "Auto");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateLibSVMAuto() throws Exception {
		Batch batch = new RattleBatch("LibSVM", "Auto");

		Set<FieldName> ignoredColumns = Sets.newHashSet(FieldName.create("mpg"), FieldName.create("predictedValue"));

		assertTrue(BatchUtil.evaluate(batch, ignoredColumns));
	}

	@Test
	public void evaluateNeuralNetworkAuto() throws Exception {
		Batch batch = new RattleBatch("NeuralNetwork", "Auto");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateRandomForestAuto() throws Exception {
		Batch batch = new RattleBatch("RandomForest", "Auto");

		assertTrue(BatchUtil.evaluate(batch));
	}

	@Test
	public void evaluateRegressionAuto() throws Exception {
		Batch batch = new RattleBatch("Regression", "Auto");

		assertEquals(null, BatchUtil.evaluateDefault(batch));

		assertTrue(BatchUtil.evaluate(batch));
	}
}
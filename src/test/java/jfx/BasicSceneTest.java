/**
 * Copyright 2024 Sebastian Proksch
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package jfx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class BasicSceneTest {

	private Button button;
	private Label label;

	@Start
	private void start(Stage primaryStage) throws IOException {

		var loader = new FXMLLoader(Main.getLocation("jfx", "basic.fxml"));
		Parent parent = loader.load();
		var scene = new Scene(parent);

		primaryStage.setTitle("Basic Example");
		primaryStage.setScene(scene);
		primaryStage.show();

		label = lookup(scene, "#mylabel");
		button = lookup(scene, "#mybutton");
	}

	@SuppressWarnings("unchecked")
	private <T> T lookup(Scene scene, String id) {
		return (T) scene.lookup(id);
	}

	@Test
	void buttonHasRightInitialLabel(FxRobot robot) {
		assertEquals("Count", button.getText());
	}

	@Test
	void labelHasRightInitialLabel(FxRobot robot) {
		assertEquals("Click the button!", label.getText());
	}

	@Test
	void clickIsCounted(FxRobot robot) {
		robot.clickOn(button);
		assertEquals("Count: 1", label.getText());
	}

	@Test
	void clicksAreCounted(FxRobot robot) {
		robot.clickOn(button);
		robot.clickOn(button);
		assertEquals("Count: 2", label.getText());
	}
}
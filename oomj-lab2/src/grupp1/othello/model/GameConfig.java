package grupp1.othello.model;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Contains information about the game configuration.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameConfig {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * Enable 3D view property.
 */
private final BooleanProperty enable3DProperty =
    new SimpleBooleanProperty(false);

/**
 * First player's name property.
 */
private final StringProperty player1NameProperty = new SimpleStringProperty();

/**
 * First player's type property.
 */
private final ObjectProperty<PlayerType> player1TypeProperty =
    new SimpleObjectProperty<>(PlayerType.HUMAN);

/**
 * Second player's name property.
 */
private final StringProperty player2NameProperty = new SimpleStringProperty();

/**
 * Second player's type property.
 */
private final ObjectProperty<PlayerType> player2TypeProperty =
    new SimpleObjectProperty<>(PlayerType.COMPUTER);

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Gets the enable 3D view property.
 *
 * @return The enable 3D view property.
 */
public final BooleanProperty enable3DProperty() {
    return (enable3DProperty);
}

/**
 * Gets the first player's name property.
 *
 * @return The first player's name property.
 */
public final StringProperty player1NameProperty() {
    return (player1NameProperty);
}

/**
 * Gets the first player's type property.
 *
 * @return The first player's type property.
 */
public final ObjectProperty<PlayerType> player1TypeProperty() {
    return (player1TypeProperty);
}

/**
 * Gets the second player's name property.
 *
 * @return The second player's name property.
 */
public final StringProperty player2NameProperty() {
    return (player2NameProperty);
}

/**
 * Gets the second player's type property.
 *
 * @return The second player's type property.
 */
public final ObjectProperty<PlayerType> player2TypeProperty() {
    return (player2TypeProperty);
}

/**
 * Gets whether 3D view should be enabled.
 *
 * @return True if 3D view should be enabled.
 */
public boolean getEnable3D() {
    return (enable3DProperty.getValue());
}

/**
 * Sets whether 3D view should be enabled.
 *
 * @param value True to enable 3D view.
 */
public void setEnable3D(boolean value) {
    enable3DProperty.setValue(value);
}

/**
 * Gets the first player's name.
 *
 * @return The first player's name.
 */
public String getPlayer1Name() {
    return (player1NameProperty.getValue());
}

/**
 * Sets the first player's name.
 *
 * @param value Player name.
 */
public void setPlayer1Name(String value) {
    player1NameProperty.setValue(value);
}

/**
 * Gets the first player's type.
 *
 * @return The first player's type.
 */
public PlayerType getPlayer1Type() {
    return (player1TypeProperty.getValue());
}

/**
 * Sets the first player's type.
 *
 * @param value Player type.
 */
public void setPlayer1Type(PlayerType value) {
    player1TypeProperty.setValue(value);
}

/**
 * Gets the second player's name.
 *
 * @return The second player's name.
 */
public String getPlayer2Name() {
    return (player2NameProperty.getValue());
}

/**
 * Sets the second player's name.
 *
 * @param value Player name.
 */
public void setPlayer2Name(String value) {
    player2NameProperty.setValue(value);
}

/**
 * Gets the first player's type.
 *
 * @return The first player's type.
 */
public PlayerType getPlayer2Type() {
    return (player2TypeProperty.getValue());
}

/**
 * Sets the first player's type.
 *
 * @param value Player type.
 */
public void setPlayer2Type(PlayerType value) {
    player2TypeProperty.setValue(value);
}

}

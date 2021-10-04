package controller.commands;

import model.IMultiLayerEditorModel;
import model.Utils;

/**
 * Function object that represents a command that will be executed on an IMultiLayerEditorModel to
 * remove a layer from the model.
 */
public class EditorRemoveCommand implements IEditorCommand {

  private final int layer;

  /**
   * Constructs an EditorRemoveCommand with the given layer in the editor to be removed.
   *
   * @param layer the layer to be removed
   * @throws IllegalArgumentException if the layer is not positive
   */
  public EditorRemoveCommand(int layer) throws IllegalArgumentException {
    if (layer < 1) {
      throw new IllegalArgumentException("Layer must be positive");
    }
    this.layer = layer - 1;
  }

  @Override
  public void execute(IMultiLayerEditorModel model) throws IllegalArgumentException {
    Utils.requireNonNull(model);
    model.removeImage(this.layer);
  }
}

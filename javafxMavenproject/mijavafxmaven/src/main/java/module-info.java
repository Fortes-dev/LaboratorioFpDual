module edu.fpdual.mijavafxmaven.mijavafxmaven {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.fpdual.mijavafxmaven.mijavafxmaven to javafx.fxml;
    exports edu.fpdual.mijavafxmaven.mijavafxmaven;
}

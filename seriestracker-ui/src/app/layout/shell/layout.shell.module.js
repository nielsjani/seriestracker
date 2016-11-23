import LayoutShellComponent from "layout/shell/layout.shell.component";
import CoreModule from "core/core.module";

export default angular
    .module("app.layout.shell", [CoreModule.name])
    .component("layoutshell", LayoutShellComponent);

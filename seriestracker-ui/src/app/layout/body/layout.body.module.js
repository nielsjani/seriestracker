import CoreModule from "core/core.module";
import LayoutBodyComponent from "layout/body/layout.body.component";

export default angular
    .module("app.layout.body", [CoreModule.name])
    .component("layoutbody", LayoutBodyComponent);

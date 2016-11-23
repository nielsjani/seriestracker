import CoreModule from "core/core.module";
import LayoutFooterComponent from "layout/footer/layout.footer.component";

export default angular
    .module("app.layout.footer", [CoreModule.name])
    .component("layoutfooter", LayoutFooterComponent);

import defaultRouteConfig from "app.route.config";
import cacheTemplates from "app.templates.run";
import LayoutModule from "layout/layout.module";
import CoreModule from "core/core.module";
import OverviewModule from "overview/overview.module";

export default angular
    .module("app", [
        CoreModule.name,
        LayoutModule.name,
        OverviewModule.name
    ])
    .config(defaultRouteConfig)
    .run(cacheTemplates);

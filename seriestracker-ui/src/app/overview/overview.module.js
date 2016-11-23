import CoreModule from "core/core.module";
import OverviewReadModule from "overview/read/overview.read.module";
import overviewRouteConfig from "overview/overview.route.config";

export default angular
    .module("app.overview", [
        OverviewReadModule.name,
        CoreModule.name
    ])
    .config(overviewRouteConfig);

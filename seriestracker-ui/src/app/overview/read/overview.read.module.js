import CoreModule from "core/core.module";
import OverviewReadComponent from "overview/read/overview.read.component";
import overviewReadRouteConfig from "overview/read/overview.read.route.config";

export default angular
    .module("app.overview.read", [CoreModule.name])
    .component("overviewRead", OverviewReadComponent)
    .config(overviewReadRouteConfig);
